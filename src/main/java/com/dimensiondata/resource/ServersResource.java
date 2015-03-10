package com.dimensiondata.resource;

import com.dimensiondata.domain.Server;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = Urls.SERVERS_URL,
                produces = {"application/json","application/xml","text/xml"},
                consumes = {"application/json","application/xml","text/xml"})
public class ServersResource extends AbstractResource {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createServers(@RequestBody @Valid List<Server> servers) {
        serverService.createServers(servers);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Server> list() {
       return  serverService.list();
    }

    @RequestMapping(value = Urls.COUNT_URL, method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Long count() {
        return serverService.count();
    }

}
