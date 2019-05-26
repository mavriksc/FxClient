
package org.mavriksc.lol.fxclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TimelineDTO {

    private Long participantId;
    private Map<String,Double> csDiffPerMinDeltas;
    private Map<String,Double> goldPerMinDeltas;
    private Map<String,Double> xpDiffPerMinDeltas;
    private Map<String,Double> creepsPerMinDeltas;
    private Map<String,Double> xpPerMinDeltas;
    private Map<String,Double> damageTakenDiffPerMinDeltas;
    private Map<String,Double> damageTakenPerMinDeltas;
    private String role;
    private String lane;

}
