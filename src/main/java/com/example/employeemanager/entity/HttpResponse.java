package com.example.employeemanager.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@JsonInclude(NON_DEFAULT)
public class HttpResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String message;

    protected Map<?,?> data;
}
