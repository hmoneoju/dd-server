package com.dimensiondata.resource.v1;

import com.dimensiondata.ApplicationConfiguration;
import com.dimensiondata.domain.Server;
import com.dimensiondata.repository.ServerRepository;
import com.google.gson.Gson;
import com.jayway.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.dimensiondata.resource.v1.Urls.SERVER_URL;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
@WebAppConfiguration
@IntegrationTest
public class ServerResourceIT {

    private static Server serverToCreate = new Server(1L,"server1");

    @Autowired
    ServerRepository serverRepo;

    @Before
    public void setUp() {
        serverRepo.deleteAll();
        createServer();
    }

    public void createServer() {
        given().
            contentType(ContentType.JSON).
            body(serverToCreate).
        when().
            post(SERVER_URL + "/" + serverToCreate.getId()).
        then().
            statusCode(HttpStatus.OK.value());
    }

    @Test
    public void conflictServer() {
        given().
            contentType(ContentType.JSON).
            body(serverToCreate).
        when().
            post(SERVER_URL+"/"+serverToCreate.getId()).
        then().
            statusCode(HttpStatus.CONFLICT.value());
    }

    @Test
    public void updateServer() {
        serverToCreate.setName("ServerModified");

        given().
            contentType(ContentType.JSON).
            body(serverToCreate).
        when().
            put(SERVER_URL+"/"+serverToCreate.getId()).
        then().
            statusCode(HttpStatus.OK.value());

        given().
            contentType(ContentType.JSON).
        when().
            get(SERVER_URL+"/"+serverToCreate.getId()).
        then().
            statusCode(HttpStatus.OK.value()).
            body(equalTo(new Gson().toJson(serverToCreate)))
        ;
    }

    @Test
    public void deleteServer() {
        given().
            contentType(ContentType.JSON).
        body(serverToCreate).
        when().
            delete(SERVER_URL+"/"+serverToCreate.getId()).
        then().
            statusCode(HttpStatus.OK.value());

        given().
            contentType(ContentType.JSON).
        when().
            get(SERVER_URL+"/"+serverToCreate.getId()).
        then().
        statusCode(HttpStatus.NOT_FOUND.value());
    }

}
