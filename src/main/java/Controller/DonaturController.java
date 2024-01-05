/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.BaseDAO;
import java.io.File;
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
import model.Donatur;

public class DonaturController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login_btn;
    @FXML
    private Hyperlink Create_acc;
    @FXML
    private Hyperlink Create_acc1;
    
    Donatur donaturAktif;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Add any necessary initialization
        initializeLoginButton();
    }    

    private void initializeLoginButton() {
        login_btn.setOnAction(e -> {
            try {
                if (authenticateLogin(username.getText(), password.getText())) {
                    // Redirect to Donatur.fxml
                    redirectToDonatur(donaturAktif);
                } else {
                    // Show login failed message
                    System.out.println("Login Failed");
                }
            } catch (SQLException ex) {
                Logger.getLogger(DonaturController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private boolean authenticateLogin(String username, String password) throws SQLException {
        // Change this to your actual method to get the database connection
        Connection con = BaseDAO.getCon(); 
        try {
            String sql = "SELECT * FROM donatur WHERE username = ? AND password = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                donaturAktif = new Donatur(rs.getString("username"), rs.getString("password"));
                donaturAktif.setIdDonatur(rs.getInt("id_donatur"));
                
                return true; // Login successful
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con); // Make sure to close the connection
        }
        return false; // Login failed
    }

    private void redirectToDonatur(Donatur d) {
    try {
        URL fxmlUrl = new File("src/main/java/model/Donasi.fxml").toURI().toURL(); // Adjust this path to the correct one for your Lupa atau Login.fxml
        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        Parent lupaLoginParent = loader.load();
        DonasiController donC = loader.getController();
        donC.setUser(d);
        donC.penanya("donatur");

        // Get the current stage (window) from the event that triggered this method
        Stage stage = (Stage) login_btn.getScene().getWindow();

        // Set the new scene onto the current stage
        Scene scene = new Scene(lupaLoginParent);
        stage.setScene(scene);
        stage.show();

    } catch (Exception e) {
        e.printStackTrace();
        // You might want to show an error message here
    }
}
}