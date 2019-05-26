package org.mavriksc.lol.fxclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

public abstract class LOLService {
    @Value("${api.key}")
    private String API_KEY;
    private static final String BASE_URL = "https://na1.api.riotgames.com/lol/";

    String getURLForPath(String endpoint){
        return BASE_URL + endpoint + String.format("?api_key=%s", API_KEY);
    }
}
