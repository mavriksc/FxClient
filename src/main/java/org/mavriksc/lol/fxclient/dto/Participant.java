
package org.mavriksc.lol.fxclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Participant {

    private Long participantId;
    private Long teamId;
    private Long championId;
    private Long spell1Id;
    private Long spell2Id;
    private String highestAchievedSeasonTier;
    private Stats stats;
    private TimelineDTO timelineDTO;

}
