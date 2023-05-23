package org.mavriksc.lol.fxclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FxClient extends Application {
    private ConfigurableApplicationContext springContext;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void init(){
        springContext = SpringApplication.run(FxClient.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoader.setLocation(getClass().getResource("/fxml/root.fxml"));
        Parent rootNode = fxmlLoader.load();

        primaryStage.setTitle("LOL CLIENT");
        Scene scene = new Scene(rootNode,1300,900);
        primaryStage.setScene(scene);
        primaryStage.show();  
    }

    @Override
    public void stop(){
        springContext.stop();
    }
}
