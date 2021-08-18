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
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Initializable {

    HistoricalEvent[] eventArray = {
            new HistoricalEvent(
                    "The Abacus - 2700 BCE",
                    "The abacus is invented in Sumer and used by the Sumerians " +
                            "in the southernmost part of Mesopotamia (which is now " +
                            "southern Iraq). The abacus device consisted of a table of " +
                            "columns and bead-like objects that were used to count " +
                            "in a sexigesimal system.\n" +
                            "\nAbaci are still used today, most commonly for people who " +
                            "are blind. ",
                    2700,
                    new Image("src/assets/abacus-image.jpg")
            ),
            new HistoricalEvent(
                    "Ada Lovelace - 1843",
                    "Ada Lovelace, a mathematician born in England in 1815 " +
                            "and lifelong associate of the inventor of the Difference " +
                            "Engine -- Charles Babbage, expands on his invention to " +
                            "create the first program for the Analytical Engine to " +
                            "compute Bernoulli numbers. " +
                            "\n" +
                            "Scholars attribute this program to be the first in our " +
                            "human history, and Ada Lovelace regarded as the first " +
                            "programmer.\n" +
                            "\n" +
                            "Every year on the second Tuesday in October, contributions " +
                            "of women in STEM are celebrated on Ada Lovelace Day.",
                    1843,
                    new Image("src/assets/ada-image.jpg")
            ),
            new HistoricalEvent(
                    "Alan Turing - 1946",
                    "Alan Turing was born in London in 1912 and studied at " +
                            "both Cambridge and Princeton universities. He was working part " +
                            "time for the British Government's Code and Cypher School before " +
                            "World War II broke out. In 1939, he took up a full time position at " +
                            "Bletchley Park in Buckinghamshire, where he made critical contributions " +
                            "in cryptography and co-invented the machine that broke the German Enigma " +
                            "Code, the first computer that he called the Bombe." +
                            "\n\n" +
                            "Turing is thought to have shortened WWII by two to four years and saved " +
                            "an estimated 21 million lives.",
                    1946,
                    new Image("src/assets/turing-image.jpg")
                    ),
            new HistoricalEvent(
                    "Grace Hopper - 1950s",
                    "Grace Hopper was born in New York City in 1906 and studied " +
                            "math and physics at Vassar College. She went on to be one of the first few " +
                            "women to earn a Ph.D in math at Yale in 1934. WWII compelled her to " +
                            "join the U.S. Naval Reserve in 1943. " +
                            "\n\n" +
                            "Given her math background, she was assigned to the Bureau of Ordinance " +
                            "Computation Project at Harvard University, where she learned to program " +
                            "a Mark I computer. She continued to work on computers after the war and " +
                            "lead a team that created the first computer language compiler, leading to " +
                            "the advent of the COBOL language. ",
                    1950,
                    new Image("src/assets/hopper-image.jpg")
            ),
            new HistoricalEvent(
                    "First Computer Science Degree - 1953",
                    "The first Computer Science Degree program was offered at the " +
                            "University of Cambridge Computer Laboratory in 1953 as the Cambridge " +
                            "Diploma in Computer Science. It was a one-year course, equivalent to " +
                            "a modern masters degree. It attracted students with degrees in math, " +
                            "science, and engineering, and at it's peak boasted 50 enrolled students. ",
                    1953,
                    new Image("src/assets/cambridge-image.jpg")
            )
    };

    @FXML
    Slider dateSlider;
    @FXML
    Label earlyDate;
    @FXML
    Label laterDate;
    @FXML
    Button backButton;
    @FXML
    ImageView backgroundImage;

    // All historical Buttons below
    @FXML
    Button eventButton1; // Starts at lowest date 2700 BCE - Abacus
    @FXML
    Button eventButton2; // Ada lovelace
    @FXML
    Button eventButton3; // Alan Turing
    @FXML
    Button eventButton4; // Grace Hopper
    @FXML
    Button eventButton5; // Ends in 1900's+ - Cambridge

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Sets the background image to a map of the world
        backgroundImage.setImage(new Image("src/assets/map-image.jpg"));

        // All buttons will be initially invisible until slider is moved except for 1st button
        eventButton1.setVisible(true);
        eventButton2.setVisible(false);
        eventButton3.setVisible(false);
        eventButton4.setVisible(false);
        eventButton5.setVisible(false);
    }

    // All button methods below
    public void backToStartScene(ActionEvent event) throws IOException {
        Parent startView = FXMLLoader.load(Main.class.getResource("fxml/StartScene.fxml"));
        Scene startViewScene = new Scene(startView);

        // This line gets the Stage information (no Stage is passed in)
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(startViewScene);
        window.show();
    }

    public void viewHistoricalEvent(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("fxml/EventScene.fxml"));
        Parent eventViewParent = loader.load();

        // Access the controller and call a method
        EventController controller = loader.getController();

        if(event.getSource().equals(eventButton1)) {
            controller.initData(eventArray[0]);
        } else if(event.getSource().equals(eventButton2)) {
            controller.initData(eventArray[1]);
        } else if(event.getSource().equals(eventButton3)) {
            controller.initData(eventArray[2]);
        } else if(event.getSource().equals(eventButton4)) {
            controller.initData(eventArray[3]);
        } else if(event.getSource().equals(eventButton5)) {
            controller.initData(eventArray[4]);
        }

        // Creates the popup window
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(eventViewParent));
        stage.setResizable(false);
        stage.show();
    }

    // Will make buttons appear
    public void onSliderChanged() {

        // So we can get the date of where our slider is pointing
        int sliderValue = (int) dateSlider.getValue();
        System.out.println(sliderValue);

        // When the slider is moved, only the correct button will appear
        if(sliderValue == 0) {
            eventButton1.setVisible(true);
            eventButton2.setVisible(false);
            eventButton3.setVisible(false);
            eventButton4.setVisible(false);
            eventButton5.setVisible(false);
        } else if(sliderValue == 6) {
            eventButton1.setVisible(false);
            eventButton2.setVisible(true);
            eventButton3.setVisible(false);
            eventButton4.setVisible(false);
            eventButton5.setVisible(false);
        } else if(sliderValue == 12) {
            eventButton1.setVisible(false);
            eventButton2.setVisible(false);
            eventButton3.setVisible(true);
            eventButton4.setVisible(false);
            eventButton5.setVisible(false);
        } else if(sliderValue == 18) {
            eventButton1.setVisible(false);
            eventButton2.setVisible(false);
            eventButton3.setVisible(false);
            eventButton4.setVisible(true);
            eventButton5.setVisible(false);
        } else if(sliderValue == 25) {
            eventButton1.setVisible(false);
            eventButton2.setVisible(false);
            eventButton3.setVisible(false);
            eventButton4.setVisible(false);
            eventButton5.setVisible(true);
        }
    }
}
