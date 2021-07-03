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
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static Article curArticle;
    private static Journal curJournal;

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
    public void initialize(URL location, ResourceBundle resources) {

        if (yearBox != null) {
            for (int i = 1800; i <= 2020; i++) {
                yearBox.getItems().add(i);
            }
        }

        if (disciplineBox != null) {
            disciplineBox.getItems().addAll("Science & Environment", "Policy", "Energy", "Economics", "Engineering", "Sustainability");
        }

    }

    public void initArticle() throws IOException {
        curArticle = new Article(authorField.getText(), yearBox.getValue().intValue(), titleField.getText());
        System.out.println("bruh");

        Parent journalInitParent = FXMLLoader.load(getClass().getResource("initJournal.fxml"));
        Scene journalInitScene = new Scene(journalInitParent);

        Stage window = (Stage)next_1.getScene().getWindow();
        window.setScene(journalInitScene);
        window.show();
    }

    public void initJournal() {
        ArrayList<String> discList = new ArrayList<String>();
        discList.addAll(disciplineBox.getItems());
        curJournal = new Journal(journalField.getText(), discList);
        curArticle.setJournal(curJournal);
        System.out.println("bruhx2");
    }
}
