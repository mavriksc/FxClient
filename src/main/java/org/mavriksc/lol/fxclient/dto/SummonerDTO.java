
package org.mavriksc.lol.fxclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SummonerDTO {

    private String id;
    private String accountId;
    private String puuid;
    private String name;
    private Long profileIconId;
    private Long revisionDate;
    private Long summonerLevel;

}
