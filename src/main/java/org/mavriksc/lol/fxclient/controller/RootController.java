package org.mavriksc.lol.fxclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import org.mavriksc.lol.fxclient.dto.SummonerDTO;
import org.mavriksc.lol.fxclient.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    private final SummonerService summonerService;

    public RootController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }


    @FXML
    private void lookUpPlayer(){
        String name  = summonerNameTextField.getText();
        SummonerDTO summoner = summonerService.getSummonerByName(name);
        System.out.println(summoner.getPuuid());
    }

}
