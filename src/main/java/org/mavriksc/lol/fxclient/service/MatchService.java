package org.mavriksc.lol.fxclient.service;

import org.mavriksc.lol.fxclient.dto.MatchDTO;
import org.mavriksc.lol.fxclient.dto.MatchList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MatchService extends LOLService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String MATCH_API = "match/v4/";
    private static final String MATCH = "matches/";
    private static final String MATCHLIST_BY_ACCOUNT = "matchlists/by-account/";

    public MatchList getMatchListForUser(String encryptedId){
        return restTemplate
                .getForObject(getURLForPath(MATCH_API+MATCHLIST_BY_ACCOUNT+encryptedId),MatchList.class);
    }

    public MatchDTO getMatchByID(Long id){
        return restTemplate.getForObject(getURLForPath(MATCH_API+MATCH+id),MatchDTO.class);
    }

}
