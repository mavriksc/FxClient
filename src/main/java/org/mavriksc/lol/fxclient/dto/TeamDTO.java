package org.mavriksc.lol.fxclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamDTO {

    private Long teamId;
    private String win;
    private Boolean firstBlood;
    private Boolean firstTower;
    private Boolean firstInhibitor;
    private Boolean firstBaron;
    private Boolean firstDragon;
    private Boolean firstRiftHerald;
    private Long towerKills;
    private Long inhibitorKills;
    private Long baronKills;
    private Long dragonKills;
    private Long vilemawKills;
    private Long riftHeraldKills;
    private Long dominionVictoryScore;
    private List<BanDTO> bans = null;

}