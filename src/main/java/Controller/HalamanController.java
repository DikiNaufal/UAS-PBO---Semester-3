/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package model;

import dao.DonaturDAO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class HalamanController implements Initializable {

    @FXML
    private Button btn_Donatur;
    @FXML
    private Button btn_organisasi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void donaturDitekan(ActionEvent event) throws IOException {
        URL fxmlUrl = new File("src/main/java/model/Donatur.fxml").toURI().toURL(); // Adjust this path to the correct one for your Lupa atau Login.fxml
        Parent lupaLoginParent = FXMLLoader.load(fxmlUrl);

        // Get the current stage (window) from the event that triggered this method
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene onto the current stage
        Scene scene = new Scene(lupaLoginParent);
        stage.setScene(scene);
        stage.show();
    }
    public void organisasiDitekan(ActionEvent event) throws IOException{
          
        URL fxmlUrl = new File("src/main/java/model/Organisasi.fxml").toURI().toURL(); // Adjust this path to the correct one for your Lupa atau Login.fxml
        Parent lupaLoginParent = FXMLLoader.load(fxmlUrl);

        // Get the current stage (window) from the event that triggered this method
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene onto the current stage
        Scene scene = new Scene(lupaLoginParent);
        stage.setScene(scene);
        stage.show();
    }
}
