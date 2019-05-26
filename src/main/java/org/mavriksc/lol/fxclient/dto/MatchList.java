package org.mavriksc.lol.fxclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class MatchList {
    private List<MatchShortDTO> matches;

    public MatchList() {
        matches = new ArrayList<>();
    }
}
