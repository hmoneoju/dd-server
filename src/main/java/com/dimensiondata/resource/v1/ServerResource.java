package com.dimensiondata.resource.v1;


import com.dimensiondata.domain.Server;
import com.dimensiondata.repository.ServerRepository;
import com.dimensiondata.resource.v1.exception.ServerAlreadyExistsException;
import com.dimensiondata.resource.v1.exception.ServerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.dimensiondata.resource.v1.Urls.*;

@RestController
@RequestMapping(value = SERVER_URL)
public class ServerResource {

    @Autowired
    ServerRepository repository;

    @RequestMapping(value ="/{id}", method = RequestMethod.POST )
    public Server create(@PathVariable Long id, @RequestBody Server server) {
        if ( repository.exists(id) )
            throw new ServerAlreadyExistsException();
        repository.save(server);
        return repository.findOne(id);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.PUT )
    public void update(@PathVariable Long id, @RequestBody Server server) {
        if ( !repository.exists(id) )
            throw new ServerNotFoundException();
        repository.save(server);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        if ( !repository.exists(id) )
            throw new ServerNotFoundException();
        repository.delete(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Server get(@PathVariable Long id) {
        if ( !repository.exists(id) )
            throw new ServerNotFoundException();
        return repository.findOne(id);
    }

}
