package com.dimensiondata.resource;


import com.dimensiondata.domain.Server;
import com.dimensiondata.service.exception.ServerAlreadyExistsException;
import com.dimensiondata.service.exception.ServerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = Urls.SERVER_URL,
                produces = {"application/json","application/xml","text/xml"},
                consumes = {"application/json","application/xml","text/xml"})
public class ServerResource extends AbstractResource {

    @RequestMapping(value ="/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Server create(@PathVariable Long id,
                         @RequestBody @Valid Server server) throws ServerAlreadyExistsException {

        return serverService.createServer(id, server);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.PUT )
    @ResponseStatus(HttpStatus.OK)
    public Server update(@PathVariable Long id,
                         @RequestBody @Valid Server server) throws ServerNotFoundException {

        return serverService.update(id, server);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ServerNotFoundException {
        serverService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Server get(@PathVariable Long id) throws ServerNotFoundException {
        return serverService.getServer(id);
    }

}
