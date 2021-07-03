package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Article;
import model.Journal;
import model.Location;
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static Article curArticle;
    private static Journal curJournal;
    private static Location curLocation;

    @FXML
    private TextField authorField;
    @FXML
    private ComboBox<Integer> yearBox;
    @FXML
    private TextField titleField;
    @FXML
    private Button next_1;
    @FXML
    private TextField journalField;
    @FXML
    private CheckComboBox disciplineBox;
    @FXML
    private Button next_2;
    @FXML
    private Button locationSelectorButton;
    @FXML
    private ComboBox<String> regionBox;
    @FXML
    private TextField countryField;
    @FXML
    private TextField stateField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField otherField;
    @FXML
    private Button back_1;
    @FXML
    private Button addLocationButton;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        if (yearBox != null) {
            for (int i = 1800; i <= 2020; i++) {
                yearBox.getItems().add(i);
            }
        }

        if (disciplineBox != null) {
            disciplineBox.getItems().addAll("Science & Environment", "Policy", "Energy", "Economics", "Engineering", "Sustainability");
        }

        if (regionBox != null) {
            regionBox.getItems().addAll("Africa", "Asia", "Oceania", "Europe", "North America", "South America");
        }

    }

    public void initArticle() throws IOException {
        curArticle = new Article(authorField.getText(), yearBox.getValue().intValue(), titleField.getText());
        System.out.println("bruh");

        //Moving to init Journal Scene
        Parent journalInitParent = FXMLLoader.load(getClass().getResource("initJournal.fxml"));
        Scene journalInitScene = new Scene(journalInitParent);

        Stage window = (Stage)next_1.getScene().getWindow();
        window.setScene(journalInitScene);
        window.show();
    }

    public void initJournal() throws IOException {
        ArrayList<String> discList = new ArrayList<String>();
        discList.addAll(disciplineBox.getItems());
        curJournal = new Journal(journalField.getText(), discList);
        curArticle.setJournal(curJournal);
        System.out.println("bruhx2");
        //TODO: implement other field feature

        //Moving to selection scene
        Parent selectionParent = FXMLLoader.load(getClass().getResource("selectionMenu.fxml"));
        Scene selectionScene = new Scene(selectionParent);

        Stage window = (Stage)next_2.getScene().getWindow();
        window.setScene(selectionScene);
        window.show();
    }

    public void loadInitLocationScene() throws IOException {
        //Moving to init location scene
        Parent locationAddParent = FXMLLoader.load(getClass().getResource("initLocation.fxml"));
        Scene locationAddScene = new Scene(locationAddParent);

        Stage window = (Stage)locationSelectorButton.getScene().getWindow();
        window.setScene(locationAddScene);
        window.show();
    }

    public void initLocation() {
        curLocation = new Location(regionBox.getValue(), countryField.getText(), stateField.getText(), cityField.getText(), otherField.getText());
        curArticle.setLocation(curLocation);
        System.out.println("Bruhx3");
        countryField.clear();
        stateField.clear();
        cityField.clear();
        otherField.clear();
    }

    public void loadSelection() throws IOException {
        //Moving to selection scene
        Parent selectionParent = FXMLLoader.load(getClass().getResource("selectionMenu.fxml"));
        Scene selectionScene = new Scene(selectionParent);

        Stage window = (Stage)back_1.getScene().getWindow();
        window.setScene(selectionScene);
        window.show();
    }
}
