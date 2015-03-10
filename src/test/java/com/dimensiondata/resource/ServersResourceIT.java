package com.dimensiondata.resource;

import com.dimensiondata.Application;
import com.dimensiondata.domain.Server;
import com.dimensiondata.repository.ServerRepository;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class ServersResourceIT {

    @Autowired
    ServerRepository serverRepo;

    @Before
    public void setup() {
        serverRepo.deleteAll();
        createAll();
    }

    @After
    public void tearDown() {
        serverRepo.deleteAll();
    }

    public void createAll() {
        List<Server> servers = getServersToCreate();
        given().
            contentType(JSON).
            body(servers).
        when().
            post(Urls.SERVERS_URL).
        then().
            statusCode(HttpStatus.OK.value());
    }

    private List<Server> getServersToCreate() {
        List<Server> servers = new ArrayList<Server>(3);
        servers.add(new Server(1L, "Server1"));
        servers.add(new Server(2L, "Server2"));
        servers.add(new Server(3L, "Server3"));
        return servers;
    }

    @Test
    public void count() {
        given().
            contentType(JSON).
        when().
            get(Urls.SERVERS_COUNT_URL).
        then().
            contentType(JSON).
            statusCode(HttpStatus.OK.value()).
            body(equalTo("3"));
    }

    @Test
    public void findAll() {
        given().
            contentType(JSON).
        when().
            get(Urls.SERVERS_URL).
        then().
            contentType(JSON).
            statusCode(HttpStatus.OK.value()).
            body(equalTo(new Gson().toJson(getServersToCreate())) );
    }

}
