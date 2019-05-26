
package org.mavriksc.lol.fxclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchShortDTO {

    private String platformId;
    private Long gameId;
    private Long champion;
    private Long queue;
    private Long season;
    private Long timestamp;
    private String role;
    private String lane;

}
