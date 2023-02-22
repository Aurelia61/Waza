package com.thales.serveur.service;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class RestService {

    //todo for connection to APi => check if it is redundant in other "services"

    private static String urlAPI = "http://localhost/8080/waza/api";

    public RestService() throws MalformedURLException {
    }

    public static String getUrlAPI() {
        return urlAPI;
    }

    public HttpsURLConnection openConnectionToAPI(String path) throws IOException {
        URL urlRequest = new URL(urlAPI+path);
        HttpsURLConnection httpRequest = (HttpsURLConnection) urlRequest.openConnection();
        return httpRequest;



    }

}
