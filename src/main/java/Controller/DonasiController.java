/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.BaseDAO;
import dao.DonasiDAO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Donasi;
import model.Campaign;
import model.Donatur;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class DonasiController implements Initializable {

    @FXML
    private Label Label_user;

    @FXML
    private Button tf_beranda;

    @FXML
    private Button tf_donatur;

    @FXML
    private Button tf_organisasi;

    @FXML
    private Button tf_campaign;

    @FXML
    private Button tf_donasi;

    @FXML
    private TextField tf_Judul;

    @FXML
    private TextField tf_jenisMakanan;

    @FXML
    private TextField tf_jumlahDonasi;

    @FXML
    private DatePicker tf_deadline;

    @FXML
    private TextField tf_namaDonatur;

    @FXML
    private DatePicker tf_tanggal;

    @FXML
    private Button btn_hapus;

    @FXML
    private Button btn_simpan;

    @FXML
    private Button btn_ubah;
    
    @FXML
    private Button close;
    
    Donatur donaturAktif;
    String pembeda="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initializeMenuButtons();
        if(pembeda=="donatur"){
            
        }else{
            
        }
    }
    
    public void penanya(String pesan){
        this.pembeda = pesan;
    }
    private void initializeMenuButtons() {
        tf_beranda.setOnAction(e -> {
            //dipencet button beranda harus apa
        });
        tf_donatur.setOnAction(e -> {
            //dipencet button donatur harus apa
        });
        tf_donasi.setOnAction(e -> {
            //dipencet button donasi harus apa
            redirectToDonasi(Label_user.getText());
        });
        tf_organisasi.setOnAction(e -> {
            //dipencet button organisasi harus apa    
        });
        tf_campaign.setOnAction(e -> {
            //dipencet button kereta langsung kesini
            redirectToCampaign(Label_user.getText());
        });
    }

    @FXML
    private void ButtonSimpanPressed(ActionEvent event) {
        // Retrieve input values from the form
        String judul = tf_Judul.getText();
        String jenisMakanan = tf_jenisMakanan.getText();
        int jumlahDonasi = Integer.parseInt(tf_jumlahDonasi.getText()); // Convert String to int
        Date deadline = Date.valueOf(tf_deadline.getValue()); // Convert LocalDate to java.sql.Date
        String namaDonatur = tf_namaDonatur.getText();
        Date tanggal = Date.valueOf(tf_tanggal.getValue()); // Convert LocalDate to java.sql.Date
        
        Campaign campaign = new Campaign("","",-1,new Date(System.currentTimeMillis()),null);
        campaign.setJudul(""); // Set empty string

        Donatur donatur = donaturAktif;
         // Set empty string
        
        

        // Create Donasi object with the form inputs
        Donasi donasi = new Donasi();
        donasi.setJenisMakanan(jenisMakanan);
        donasi.setJumlahDonasi(jumlahDonasi);
        donasi.setDeadline(deadline);
        donasi.setTanggal(tanggal);

        // Save the donation using DonasiDAO
        DonasiDAO dao = new DonasiDAO();
        dao.saveDonation(donasi, campaign, donatur);

        // Optionally, you can clear the form here or give some confirmation message
    }
    
    @FXML
    private void handleCloseButton(ActionEvent event) throws IOException {
        URL fxmlUrl = new File("src/main/java/model/Halaman.fxml").toURI().toURL(); // Adjust this path to the correct one for your Lupa atau Login.fxml
        Parent lupaLoginParent = FXMLLoader.load(fxmlUrl);

        // Get the current stage (window) from the event that triggered this method
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene onto the current stage
        Scene scene = new Scene(lupaLoginParent);
        stage.setScene(scene);
        stage.show();
    }
    
    public void setUser(Donatur donaturAktif){
        this.donaturAktif = donaturAktif;
        Label_user.setText(this.donaturAktif.getNama());
    }

    private void redirectToDonasi(String username) {
        try {
            URL fxmlUrl = new File("src/main/java/model/Donasi.fxml").toURI().toURL(); // Adjust this path to the correct one for your Lupa atau Login.fxml
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent lupaLoginParent = loader.load();
            DonasiController donC = loader.getController();
            donC.setUser(donaturAktif);
            // Get the current stage (window) from the event that triggered this method
            Stage stage = (Stage) tf_donasi.getScene().getWindow();
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
            Stage stage = (Stage) tf_campaign.getScene().getWindow();
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

}
