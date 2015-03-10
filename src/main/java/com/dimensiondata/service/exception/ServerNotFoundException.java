package com.dimensiondata.service.exception;

public class ServerNotFoundException extends Exception {

    Long serverId;

    public ServerNotFoundException(Long serverId) {
        super("Server with id " +serverId+ " does not exist");
        this.serverId = serverId;
    }


}
