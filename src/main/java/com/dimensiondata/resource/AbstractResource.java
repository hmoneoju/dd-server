package com.dimensiondata.resource;

import com.dimensiondata.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbstractResource {

    @Autowired
    ServerService serverService;

}
