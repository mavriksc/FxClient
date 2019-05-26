
package org.mavriksc.lol.fxclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private String platformId;
    private String accountId;
    private String summonerName;
    private String summonerId;
    private String currentPlatformId;
    private String currentAccountId;
    private String matchHistoryUri;
    private Long profileIcon;

}
