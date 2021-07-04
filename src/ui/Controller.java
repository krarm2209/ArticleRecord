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
import model.Mine;
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static Article curArticle;
    private static Journal curJournal;
    private static Location curLocation;
    private static Mine curMine;

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
    private CheckComboBox<String> disciplineBox;
    @FXML
    private Button next_2;
    @FXML
    private Button locationSelectorButton;
    @FXML
    private Button mineSelectorButton;
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
    private TextField commodityField;
    @FXML
    private CheckComboBox<String> miningMethodBox;
    @FXML
    private Button researchSelectorButton;
    @FXML
    private CheckComboBox<String> researchMethodBox;
    @FXML
    private Button pmluSelectorButton;
    @FXML
    private CheckComboBox<String> pmluBox;
    @FXML
    private Button topicSelectorButton;
    @FXML
    private CheckComboBox<String> topicBox;
    @FXML
    private Button dataTypeSelectorButton;
    @FXML
    private ComboBox<String> dataTypeBox;


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

        if (miningMethodBox != null) {
            miningMethodBox.getItems().addAll("Open-Pit", "Underground", "Placer", "In-Situ", "Mixed (To specify)");
        }

        if (researchMethodBox != null) {
            researchMethodBox.getItems().addAll("Experimental (Laboratory)", "Modelling", "Observational", "Survey", "Interviews", "Field Studies", "Case Studies", "Document Analysis", "Meta-Analysis", "GIS", "Other (To specify)");
        }

        if (pmluBox != null) {
            pmluBox.getItems().addAll("Aquaculture", "Native Ecosystems", "Biodiversity Corridor", "Reuse of residue", "Renewable Energy", "Protected Horticulture", "Hydroponics", "Cropping", "Tourism", "Regenerative Agriculture", "Intensive Livestock Production", "Grazing", "Other (To specify)");
        }

        if (topicBox != null) {
            topicBox.getItems().addAll("Post Mining Land Use", "Mine Rehabilitation", "Mixed", "Other (To specify)");
        }

        if (dataTypeBox != null) {
            dataTypeBox.getItems().addAll("Qualitative", "Quantitative", "Mixed");
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
        ArrayList<String> tempList = new ArrayList<String>(disciplineBox.getCheckModel().getCheckedItems());
        curJournal = new Journal(journalField.getText(), tempList);
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
        regionBox.setValue(null);
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

    public void loadInitMineScene() throws IOException {
        Parent addMineParent = FXMLLoader.load(getClass().getResource("initMine.fxml"));
        Scene addMineScene = new Scene(addMineParent);

        Stage window = (Stage)mineSelectorButton.getScene().getWindow();
        window.setScene(addMineScene);
        window.show();
    }

    public void initMine() {
        ArrayList<String> tempList = new ArrayList<String>(miningMethodBox.getCheckModel().getCheckedItems());
        curMine = new Mine(commodityField.getText(), tempList);
        miningMethodBox.getCheckModel().clearChecks();
        curArticle.setMine(curMine);
        System.out.println("Bruhx4");
        commodityField.clear();
    }

    public void loadInitResearchMethodScene() throws IOException {
        Parent researchMethodParent = FXMLLoader.load(getClass().getResource("initResearchMethod.fxml"));
        Scene researchMethodScene = new Scene(researchMethodParent);

        Stage window = (Stage)researchSelectorButton.getScene().getWindow();
        window.setScene(researchMethodScene);
        window.show();
    }

    public void initResearchMethod() {
        ArrayList<String> tempList = new ArrayList<String>(researchMethodBox.getCheckModel().getCheckedItems());
        curArticle.setResearchMethods(tempList);
        System.out.println("bruhx5");
        researchMethodBox.getCheckModel().clearChecks();
    }

    public void loadInitPmluScene() throws IOException {
        Parent addPmluParent = FXMLLoader.load(getClass().getResource("initPmlu.fxml"));
        Scene addPmluScene = new Scene(addPmluParent);

        Stage window = (Stage)pmluSelectorButton.getScene().getWindow();
        window.setScene(addPmluScene);
        window.show();
    }

    public void initPmlu() {
        ArrayList<String> tempList = new ArrayList<String>(pmluBox.getCheckModel().getCheckedItems());
        curArticle.setPMLU(tempList);
        System.out.println("Bruhx6");
        pmluBox.getCheckModel().clearChecks();
    }

    public void loadInitTopicScene() throws IOException {
        Parent addTopicParent = FXMLLoader.load(getClass().getResource("initTopic.fxml"));
        Scene addTopicScene = new Scene(addTopicParent);

        Stage window = (Stage)topicSelectorButton.getScene().getWindow();
        window.setScene(addTopicScene);
        window.show();
    }

    public void initTopic() {
        ArrayList<String> tempList = new ArrayList<String>(topicBox.getCheckModel().getCheckedItems());
        curArticle.setTopic(tempList);
        topicBox.getCheckModel().clearChecks();
        System.out.println("bruhx7");
    }

    public void loadInitDataTypeScene() throws IOException {
        Parent addDataTypeParent = FXMLLoader.load(getClass().getResource("initDataType.fxml"));
        Scene addDataTypeScene = new Scene(addDataTypeParent);

        Stage window = (Stage)dataTypeSelectorButton.getScene().getWindow();
        window.setScene(addDataTypeScene);
        window.show();
    }

    public void initDataType() {
        curArticle.setDataType(dataTypeBox.getValue());
        dataTypeBox.setValue(null);
        System.out.println("Bruhx8");
    }
}
