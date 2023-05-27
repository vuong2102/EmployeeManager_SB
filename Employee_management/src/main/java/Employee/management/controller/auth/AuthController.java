package Employee.management.controller.auth;

import Employee.management.dto.auth.UserResponse;
import Employee.management.repository.error.ArgumentException;
import Employee.management.repository.error.ResourceFoundException;
import Employee.management.repository.error.ResourceNotFoundException;
import Employee.management.service.auth.IAuthService;
import Employee.management.service.auth.TokenProvider;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import Employee.management.dto.auth.AuthRequest;
import Employee.management.dto.auth.AuthResponse;
import Employee.management.model.Employee;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/", produces = "application/json")
public class AuthController {

    private final PasswordEncoder passwordEncoder;

    private final IAuthService iAuthService;
    private final TokenProvider tokenProvider;

    @Value("${app.auth.tokenCookieName}")
    public String tokenCookieName;


    @GetMapping("get-user-info")
    public AuthResponse getUserInfo(@RequestParam String access) {
        Claims claims = tokenProvider.decodeJwt(access);
        String email = claims.getSubject();
        final var user = iAuthService.fetchUser(email);

        if (user == null) {
            throw new ResourceNotFoundException(email);
        }
        return new AuthResponse(user, access);
    }

    @PostMapping("sign-up")
    public String createUser(@RequestBody Employee clientEntity) {
        try {
            String encodedPassword = passwordEncoder.encode(clientEntity.getPassword());
            UserResponse userResponse = new UserResponse(clientEntity, encodedPassword);
            String email = clientEntity.getEmail();

            final var user = iAuthService.fetchUser(email);
            if (user == null) {
                iAuthService.saveUser(userResponse);
            } else {
                throw new ResourceFoundException("email");
            }
            return "Bạn đã đăng ký thành công";
        } catch (ArgumentException ae) {
            throw new ArgumentException(ae.getMessage());
        }
    }

    @PostMapping("sign-in")
    public AuthResponse authResponse(@RequestBody @Valid AuthRequest authRequest, HttpServletResponse response) {
        final String email = authRequest.getEmail();
        final String password = authRequest.getPassword();
        final var user = iAuthService.fetchUser(email);

        if (user == null) {
            throw new ResourceNotFoundException(email);
        }

        boolean isMatcher = passwordEncoder.matches(password, user.getPassword());
        if (!isMatcher) {
            throw new ResourceNotFoundException(email);
        } else {
            final var token = tokenProvider.createJwtToken(email);
            addTokenCookie(response, tokenCookieName, token);
            return new AuthResponse(user, token);
        }
    }


    private void addTokenCookie(HttpServletResponse response, final String cookieName, final String token) {
        ResponseCookie cookie = ResponseCookie.from(cookieName, token)
                .path("/")
                .maxAge(4 * 24 * 60 * 60) // 4 days
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
    }
}
