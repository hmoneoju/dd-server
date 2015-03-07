package com.dimensiondata.resource.v1;

import com.dimensiondata.domain.Server;
import com.dimensiondata.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dimensiondata.util.IterableUtils.toList;
import static com.dimensiondata.resource.v1.Urls.*;

@RestController
@RequestMapping(SERVERS_URL)
public class ServersResource {

    @Autowired
    ServerRepository serverRepo;

    @RequestMapping(method = RequestMethod.POST)
    public void addAllorNone(@RequestBody List<Server> servers) {
        serverRepo.save(servers);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Server> getAll() {
       return  toList(serverRepo.findAll());
    }

    @RequestMapping(value = COUNT_URL, method= RequestMethod.GET)
    public long count() {
        return serverRepo.count();
    }

}
