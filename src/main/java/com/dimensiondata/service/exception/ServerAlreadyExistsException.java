package com.dimensiondata.service.exception;

public class ServerAlreadyExistsException extends Exception {

    Long serverId;

    public ServerAlreadyExistsException(Long serverId) {
        super("Server with id " +serverId+ " already exists");
        this.serverId = serverId;
    }
}
