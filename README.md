## Introduction

This is a REST service that manages the server inventory.

## System requirements

You just need maven 3.2 and java 7 or above. As any other standard maven project you generate the artifact by running _mvn clean install_

## Running the application

The artifact produced by maven is an executable jar (with an embedded DB and Tomcat), so you can start the REST service using _java -jar_.

*hector@Iscariot ~/IdeaProjects/dd-client $java -jar ./target/dd-server-1.0.jar* &

Logs are saved into ./logs/dimensiondata.log file

## Technical design

This service has been built using SpringBoot which is a Spring add-on that makes bootstrapping Spring applications much easier, kind of a maven
archetype but to the next level.

The service is a classic MVC layered in:

1. Persistence - I have used Spring Data / JPA. The ServerRepository offers an interface to the service layer. The service is configured to use
an in-memory DB.
2. Service -  The service layer defines an interface with the Server operations which will be exposed to the resource layer. It talks with the
pesistence layer
3. Resource - is the public interface for other services/applications/clients. It is a rest endpoint built with Spring Rest Controller. The service
is configured to run in an embedded Tomcat server. The port used is 8080

I have enabled the production mode feature within the SpringBoot configuration, which means we get for free realtime metrics http://localhost:8080/metrics
and health check http://localhost:8080/health.

From the testing perspective there are two integration tests for end to end testing.

