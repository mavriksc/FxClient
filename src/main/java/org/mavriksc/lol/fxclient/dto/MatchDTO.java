package org.mavriksc.lol.fxclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchDTO {

private Long gameId;
private String platformId;
private Long gameCreation;
private Long gameDuration;
private Long queueId;
private Long mapId;
private Long seasonId;
private String gameVersion;
private String gameMode;
private String gameType;
private List<TeamDTO> teams = null;
private List<Participant> participants = null;
private List<ParticipantIdentity> participantIdentities = null;

}