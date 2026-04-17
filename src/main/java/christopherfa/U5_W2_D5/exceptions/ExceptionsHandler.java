package christopherfa.U5_W2_D5.exceptions;

import christopherfa.U5_W2_D5.payloads.ErrorsPayload;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayload handleRuntimeException(RuntimeException e) {
        return new ErrorsPayload(e.getMessage(), LocalDateTime.now());
    }

    // errori di validazione
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayload handleValidation(org.springframework.web.bind.MethodArgumentNotValidException e) {
        return new ErrorsPayload("Errore di validazione: " + e.getBindingResult().getFieldError().getDefaultMessage(), LocalDateTime.now());
    }

    // errori server
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayload handleGeneric(Exception e) {
        return new ErrorsPayload("Errore lato server, boh!", LocalDateTime.now());
    }
}