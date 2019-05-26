package org.mavriksc.lol.fxclient.service;

import org.mavriksc.lol.fxclient.dto.SummonerDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SummonerService extends LOLService {
    private final RestTemplate lolRestTemplate = new RestTemplate();
    private static final String SUMMONER_API = "summoner/v4/summoners/";
    private static final String SUMMONER_BY_NAME = "by-name/";

    public SummonerDTO getSummonerByName(String name) {
        return lolRestTemplate
                .getForEntity(getURLForPath(SUMMONER_API + SUMMONER_BY_NAME + name ), SummonerDTO.class)
                .getBody();
    }
}
