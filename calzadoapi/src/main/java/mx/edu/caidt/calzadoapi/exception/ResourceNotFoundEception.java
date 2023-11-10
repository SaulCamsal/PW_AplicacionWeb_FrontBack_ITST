package mx.edu.caidt.calzadoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundEception extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundEception(String message) {
        super(message);
    }
}
