package com.dimensiondata.resource.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "There is already a server with that ID")
public class ServerAlreadyExistsException extends ServerRuntimeException {
}
