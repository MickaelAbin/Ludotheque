package fr.eni.ludotheque.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request) {
        System.err.println("Accès refusé à l'URL : " + request.getRequestURL());
        ex.printStackTrace();
        return "403";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        ex.printStackTrace();
        return "error";
    }
}
