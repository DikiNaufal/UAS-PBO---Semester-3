
import dao.DonaturDAO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Donatur;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author user
 */
public class FoodShareMaven extends Application{

    
    @Override
    public void start(Stage stage) throws MalformedURLException, IOException {
          URL url = new File("src/main/java/model/Halaman.fxml").toURI().toURL();
          Parent root = FXMLLoader.load(url);
          Scene scene = new Scene(root);
          stage.centerOnScreen();
          stage.setScene(scene);
          stage.show();       
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
