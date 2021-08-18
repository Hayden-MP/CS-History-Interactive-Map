package interactive_map.controllers;

import interactive_map.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @FXML
    Button startButton;
    @FXML
    Button quitButton;
    @FXML
    ImageView backgroundImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backgroundImage.setImage(new Image("src/assets/start-image.jpg"));
    }

    // When this button is pushed it will change the scene to the Map
    public void mapScene(ActionEvent actionEvent) throws IOException {
        Parent mapView = FXMLLoader.load(Main.class.getResource("fxml/MapScene.fxml"));
        Scene mapViewScene = new Scene(mapView);

        // This line gets the Stage information (no Stage is passed in)
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(mapViewScene);
        window.show();
    }


    // Simply ends the program
    public void quitProgram(ActionEvent actionEvent) {
        System.exit(0);
    }

}
