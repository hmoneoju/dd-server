package com.dimensiondata.service;

import com.dimensiondata.domain.Server;
import com.dimensiondata.service.exception.ServerAlreadyExistsException;
import com.dimensiondata.service.exception.ServerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServerService {

    Server createServer(Long id, Server server) throws ServerAlreadyExistsException;

    Server getServer(Long id) throws ServerNotFoundException;

    long count();

    Server update(Long id, Server server) throws ServerNotFoundException;

    void delete(Long id) throws ServerNotFoundException;

    void createServers(List<Server> servers);

    List<Server> list();

}
