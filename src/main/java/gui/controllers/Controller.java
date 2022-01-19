package gui.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Controller {
    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button healthSceneBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private ImageView mainImage;

    @FXML
    private Button showMedBtn;

    @FXML
    private Button sknBtn;

    @FXML
    private Label titleLabel;

    @FXML
    private HBox topHBox;

    @FXML
    private Button vitBtn;
    @FXML
    void showMeds(ActionEvent event) {

    }

    public void switchToMainScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:\\Users\\Bogdan.420\\IdeaProjects\\DrugStoreV2\\src\\main\\java\\gui\\fxml\\DrugStore.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root, 964, 615);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToMedsScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:\\Users\\Bogdan.420\\IdeaProjects\\DrugStoreV2\\src\\main\\java\\gui\\fxml\\MedScene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root, 964, 615);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public void switchToHealthScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:\\Users\\Bogdan.420\\IdeaProjects\\DrugStoreV2\\src\\main\\java\\gui\\fxml\\HealthScene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root, 964, 615);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToVitaminScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:\\Users\\Bogdan.420\\IdeaProjects\\DrugStoreV2\\src\\main\\java\\gui\\fxml\\VitScene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root, 964, 615);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToScScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:\\Users\\Bogdan.420\\IdeaProjects\\DrugStoreV2\\src\\main\\java\\gui\\fxml\\ScScene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root, 964, 615);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    @FXML
    void initialize() {
        assert healthSceneBtn != null : "fx:id=\"healthSceneBtn\" was not injected: check your FXML file 'DrugStore.fxml'.";
        assert homeBtn != null : "fx:id=\"homeBtn\" was not injected: check your FXML file 'DrugStore.fxml'.";
        assert mainImage != null : "fx:id=\"mainImage\" was not injected: check your FXML file 'DrugStore.fxml'.";
        assert showMedBtn != null : "fx:id=\"showMedBtn\" was not injected: check your FXML file 'DrugStore.fxml'.";
        assert sknBtn != null : "fx:id=\"sknBtn\" was not injected: check your FXML file 'DrugStore.fxml'.";
        assert titleLabel != null : "fx:id=\"titleLabel\" was not injected: check your FXML file 'DrugStore.fxml'.";
        assert topHBox != null : "fx:id=\"topHBox\" was not injected: check your FXML file 'DrugStore.fxml'.";
        assert vitBtn != null : "fx:id=\"vitBtn\" was not injected: check your FXML file 'DrugStore.fxml'.";

    }

}
