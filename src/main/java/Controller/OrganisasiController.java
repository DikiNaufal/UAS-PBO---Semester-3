/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.BaseDAO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrganisasiController implements Initializable {

    @FXML
    private Button login_btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Add any necessary initialization
        initializeLoginButton();
    }    

    private void initializeLoginButton() {
        login_btn.setOnAction(e -> {
            URL fxmlUrl = null;
            try {
                fxmlUrl = new File("src/main/java/model/Donasi.fxml").toURI().toURL(); // Adjust this path to the correct one for your Lupa atau Login.fxml
            } catch (MalformedURLException ex) {
                Logger.getLogger(OrganisasiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Parent lupaLoginParent = null;
            try {
                lupaLoginParent = FXMLLoader.load(fxmlUrl);
            } catch (IOException ex) {
                Logger.getLogger(OrganisasiController.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Get the current stage (window) from the event that triggered this method
            Stage stage = (Stage) login_btn.getScene().getWindow();

            // Set the new scene onto the current stage
            Scene scene = new Scene(lupaLoginParent);
            stage.setScene(scene);
            stage.show();
        });
    }
}