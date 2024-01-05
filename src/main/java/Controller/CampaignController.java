/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.CampaignDAO;
import dao.DonasiDAO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Campaign;
import model.Donasi;
import model.Donatur;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class CampaignController implements Initializable {

    @FXML
    private Label Label_User;
    @FXML
    private Button button_beranda;
    @FXML
    private Button button_donatur;
    @FXML
    private Button button_organisasi;
    @FXML
    private Button button_campaign;
    @FXML
    private Button button_donasi;
    @FXML
    private TableView<?> tableview_campaign;
    @FXML
    private Button button_kembali;
    @FXML
    private Button button_keluar;
    
    Donatur donaturAktif;
    String pembeda="";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(pembeda=="donatur"){
            
        }
        else{
            
        }
        button_organisasi.setOnAction(e->{
            try {
                URL fxmlUrl = new File("src/main/java/model/Organisasi.fxml").toURI().toURL(); // Adjust this path to the correct one for your Lupa atau Login.fxml
                FXMLLoader loader = new FXMLLoader(fxmlUrl);
                Parent lupaLoginParent = loader.load();
                OrganisasiController donC = loader.getController();
                // Get the current stage (window) from the event that triggered this method
                Stage stage = (Stage) button_organisasi.getScene().getWindow();
                // Set the new scene onto the current stage
                Scene scene = new Scene(lupaLoginParent);
                stage.setScene(scene); 
                stage.show();
            } catch (MalformedURLException ex) {
                Logger.getLogger(CampaignController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CampaignController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void penanya(String pesan){
        this.pembeda = pesan;
    }
    
    public void setUser(Donatur donaturAktif){
        this.donaturAktif = donaturAktif;
        Label_User.setText(this.donaturAktif.getNama());
    } 
    private void initializeMenuButtons() {
        button_beranda.setOnAction(e -> {
            //dipencet button beranda harus apa
        });
        button_donatur.setOnAction(e -> {
            //dipencet button donatur harus apa
        });
        button_donasi.setOnAction(e -> {
            //dipencet button donasi harus apa
            redirectToDonasi(Label_User.getText());
        });
        button_organisasi.setOnAction(e -> {
            //dipencet button organisasi harus apa    
        });
        button_campaign.setOnAction(e -> {
            //dipencet button kereta langsung kesini
            redirectToCampaign(Label_User.getText());
        });
    }
    private void redirectToDonasi(String username) {
        try {
            URL fxmlUrl = new File("src/main/java/model/Donasi.fxml").toURI().toURL(); // Adjust this path to the correct one for your Lupa atau Login.fxml
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent lupaLoginParent = loader.load();
            DonasiController donC = loader.getController();
            donC.setUser(donaturAktif);
            // Get the current stage (window) from the event that triggered this method
            Stage stage = (Stage) button_donasi.getScene().getWindow();
            // Set the new scene onto the current stage
            Scene scene = new Scene(lupaLoginParent);
            stage.setScene(scene);
            stage.show();
        } catch (MalformedURLException ex) {
            Logger.getLogger(DonasiController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DonasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void redirectToCampaign(String username) {
        try {
            URL fxmlUrl = new File("src/main/java/model/Campaign.fxml").toURI().toURL(); // Adjust this path to the correct one for your Lupa atau Login.fxml
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent lupaLoginParent = loader.load();
            CampaignController camC = loader.getController();
            camC.setUser(donaturAktif);
            // Get the current stage (window) from the event that triggered this method
            Stage stage = (Stage) button_campaign.getScene().getWindow();
            // Set the new scene onto the current stage
            Scene scene = new Scene(lupaLoginParent);
            stage.setScene(scene);
            stage.show();
        } catch (MalformedURLException ex) {
            Logger.getLogger(DonasiController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DonasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ambilDataTabel(){
        DonasiDAO dDAO = new DonasiDAO();
//        ArrayList<Donasi> = dDAO.getAllDonations(campaign, donaturAktif);

    }

}
