/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author roboto
 */
public class main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Read.Leer(primaryStage);
        
        primaryStage.setTitle("English III Paralelo:8");
        primaryStage.setScene(Read.ventanas.getFirst().getScene());
        primaryStage.show();
        System.out.println("Number Questions: " + String.valueOf(Read.ventanas.getSize()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
