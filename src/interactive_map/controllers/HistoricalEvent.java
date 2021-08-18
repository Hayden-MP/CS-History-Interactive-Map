package interactive_map.controllers;

import javafx.scene.image.Image;

public class HistoricalEvent {

    // Instance variables
    private String eventTitle;
    private String eventDescription;
    private int year;
    Image image;

    // Default Constructor
    HistoricalEvent() { }

    // Constructor
    HistoricalEvent(String newEventTitle, String newEventDescription, int newYear, Image newImage) {
        this.eventTitle = newEventTitle;
        this.eventDescription = newEventDescription;
        this.year = newYear;
        this.image = newImage;
    }

    // Getters/Setters
    public void setHistoricalEvent(String newEventTitle) {
        this.eventTitle = newEventTitle;
    }
    public void setHistoricalPerson(String newEventDescription) {
        this.eventDescription = newEventDescription;
    }
    public void setYear(int newYear) {
        this.year = newYear;
    }
    public void setImage(Image newImage) {
        this.image = newImage;
    }

    public String getEventTitle() {
        return eventTitle;
    }
    public String getEventDescription() {
        return eventDescription;
    }
    public int getYear() {
        return year;
    }
    public Image getImage() {
        return image;
    }


    // toString method
    public String toString() {
        return "Historical Event: " + this.eventTitle
                + "\nHistorical Person: " + this.eventDescription
                + "\nYear: " + this.year;
    }

}
