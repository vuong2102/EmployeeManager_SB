package Employee.management.config;


import Employee.management.repository.error.ArgumentException;
import Employee.management.repository.error.ResourceFoundException;
import Employee.management.repository.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(ResourceNotFoundException ex) {
        // handle exception
        return new ResponseEntity<>("Email " + ex.getMessage()+" không tồn tại hoặc mật khẩu sai!",
                                    HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ResourceFoundException.class)
    public ResponseEntity<String> handleFoundException(ResourceFoundException ex) {
        // handle exception
        return new ResponseEntity<>("Tài khoản đã tồn tại: " + ex.getMessage(), HttpStatus.FOUND);
    }
    @ExceptionHandler(value = ArgumentException.class)
    public ResponseEntity<String> handleArgumentException(ArgumentException ex) {
        return new ResponseEntity<>("Có lỗi xảy ra: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
