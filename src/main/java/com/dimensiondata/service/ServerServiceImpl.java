package com.dimensiondata.service;

import com.dimensiondata.domain.Server;
import com.dimensiondata.repository.ServerRepository;
import com.dimensiondata.service.exception.ServerAlreadyExistsException;
import com.dimensiondata.service.exception.ServerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.dimensiondata.util.IterableUtils.toList;

@Component
public class ServerServiceImpl implements ServerService{

    @Autowired
    private ServerRepository repository;

    @Transactional(readOnly = false)
    @Override
    public Server createServer(Long id, Server server) throws ServerAlreadyExistsException {
        if ( repository.exists(id) )
            throw new ServerAlreadyExistsException(id);
        repository.save(server);
        return repository.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Server getServer(Long id) throws ServerNotFoundException {
        if ( !repository.exists(id) )
            throw new ServerNotFoundException(id);
        return repository.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return repository.count();
    }

    @Transactional(readOnly = false)
    @Override
    public Server update(Long id, Server server) throws ServerNotFoundException {
        if ( !repository.exists(id) )
            throw new ServerNotFoundException(id);

        repository.save(new Server(id, server.getName()) );
        return repository.findOne(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Long id) throws ServerNotFoundException {
        if ( !repository.exists(id) )
            throw new ServerNotFoundException(id);
        repository.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void createServers(List<Server> servers) {
        repository.save(servers);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Server> list() {
        return toList(repository.findAll());
    }
}
