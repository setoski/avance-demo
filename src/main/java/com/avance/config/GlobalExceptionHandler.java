package com.avance.config;

import com.avance.error.CTRLException;
import com.avance.error.DAOException;
import com.avance.error.SVCException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DAOException.class})
    public ResponseEntity<Map<String, Object>> isDAOException(DAOException ex, WebRequest request) {
        Map<String, Object> errorMsg = new HashMap<String, Object>() {
            {
                put("status", 500);
                put("message", ex.getMessage());
            }
        };
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg);
    }

    @ExceptionHandler(SVCException.class)
    public ResponseEntity<Map<String, Object>> isSVCException(SVCException ex, WebRequest request) {
        Map<String, Object> errorMsg = new HashMap<String, Object>() {
            {
                put("status", 500);
                put("message", ex.getMessage());
            }
        };
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg);
    }

    @ExceptionHandler(CTRLException.class)
    public ResponseEntity<Map<String, Object>> isCTRLException(CTRLException ex, WebRequest request) {
        Map<String, Object> errorMsg = new HashMap<String, Object>() {
            {
                put("status", 500);
                put("message", ex.getMessage());
            }
        };
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> isConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        Map<String, Object> errorMsg = new HashMap<String, Object>() {
            {
                put("status", 400);
                put("message", ex.getMessage());
            }
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);
    }
}
