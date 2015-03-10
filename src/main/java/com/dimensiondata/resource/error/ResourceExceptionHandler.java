package com.dimensiondata.resource.error;

import com.dimensiondata.service.exception.ServerAlreadyExistsException;
import com.dimensiondata.service.exception.ServerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServerNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody Object handleServerNotFound(ServerNotFoundException e) {
        return new ErrorMessage( e.getMessage() );
    }

    @ExceptionHandler(ServerAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ResponseBody Object handleServerAlreadyExists(ServerAlreadyExistsException e) {
        return new ErrorMessage( e.getMessage() );
    }

}
