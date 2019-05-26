package org.mavriksc.lol.fxclient.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.mavriksc.lol.fxclient.dto.MatchDTO;
import org.mavriksc.lol.fxclient.dto.MatchShortDTO;
import org.mavriksc.lol.fxclient.dto.Participant;
import org.mavriksc.lol.fxclient.dto.ParticipantIdentity;
import org.mavriksc.lol.fxclient.dto.SummonerDTO;
import org.mavriksc.lol.fxclient.service.MatchService;
import org.mavriksc.lol.fxclient.service.SummonerService;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class RootController {
    @FXML
    private TextField summonerNameTextField;
    @FXML
    private Button lookUpButton;
    @FXML
    private Tab historyTab;
    @FXML
    private Tab liveTab;
    @FXML
    private Label summonerLbl;
    @FXML
    private Label DPS;
    @FXML
    private Label totalDamage;
    @FXML
    private CheckBox liveGameCkbx;

    private final SummonerService summonerService;
    private final MatchService matchService;

    private long lstDmg = 0L;

    @FXML
    private void lookUpPlayer() {
        String name = summonerNameTextField.getText();
        SummonerDTO summoner = summonerService.getSummonerByName(name);
        List<MatchShortDTO> matches = matchService.getMatchListForUser(summoner.getAccountId()).getMatches();
        summonerLbl.setText(name+" "+ new Date(matches.get(0).getTimestamp()).toString());
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2100), event -> {
            if (liveGameCkbx.isSelected()) {
                MatchDTO match = matchService.getMatchByID(matches.get(0).getGameId());
                ParticipantIdentity participantIdentity = match.getParticipantIdentities()
                        .stream()
                        .filter(pi -> pi.getPlayer().getSummonerName().equals(name)).findFirst().get();
                Participant participant = match
                        .getParticipants().stream()
                        .filter(p -> p.getParticipantId().longValue() == participantIdentity.getParticipantId())
                        .findFirst().get();
                long dps = (participant.getStats().getTotalDamageDealt() - lstDmg) / 2;

                lstDmg = participant.getStats().getTotalDamageDealt();
                DPS.setText(String.format("DPS: %d /s", dps));
                totalDamage.setText(String.format("Total Damage: %s", participant.getStats().getTotalDamageDealt().toString()));

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    public RootController(SummonerService summonerService, MatchService matchService) {
        this.summonerService = summonerService;
        this.matchService = matchService;
    }

}
