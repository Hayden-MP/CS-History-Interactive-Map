package interactive_map.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EventController {

    private HistoricalEvent event;

    @FXML
    Label historyTitle;
    @FXML
    Label historyDescription;
    @FXML
    ImageView historyImage;
    @FXML
    Button closeButton;

    // This method accepts a HistoricalEvent object to initialize the pane
    public void initData(HistoricalEvent newEvent) {
        event = newEvent;
        historyTitle.setText(event.getEventTitle());
        historyDescription.setText(event.getEventDescription());
        historyImage.setImage(event.getImage());
    }

    public void closeWindow(ActionEvent event) {
        Node  source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
