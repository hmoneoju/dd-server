package com.dimensiondata.resource;

public class Urls {

    public static final String VERSION = "v1";
    public static final String SERVERS = "servers";
    public static final String SERVERS_URL = "/" + VERSION +"/"+ SERVERS ;
    public static final String COUNT_URL = "/count";
    public static final String SERVERS_COUNT_URL = SERVERS_URL + COUNT_URL;


    public static final String SERVER = "server";
    public static final String SERVER_URL = SERVERS_URL +"/"+ SERVER;

}
