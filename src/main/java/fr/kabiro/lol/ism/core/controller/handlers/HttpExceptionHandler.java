package fr.kabiro.lol.ism.core.controller.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HttpExceptionHandler{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler
    public ResponseEntity<Object> handleException(HttpServletRequest req, Exception ex){
        log.info("Handling exception {}", ex);
        if (ex instanceof HttpStatusCodeException){
            return new ResponseEntity<>(((HttpStatusCodeException) ex).getStatusCode());
        }
        log.error("Uncatched exception {} for {} {}", ex, req.getMethod(), req.getRequestURI());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

