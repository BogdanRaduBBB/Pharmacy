
package gui.controllers;

import dbConnection.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pojo.Medicine;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;


public class ScController implements Initializable {
    private final DBConnection dbConnection = new DBConnection();
    private Scene scene;
    private Stage stage;
    private Parent root;
    private final ObservableList<Medicine> toBuy = FXCollections.observableArrayList();


    @FXML
    private Button addToCartBtn;

    @FXML
    private MenuItem ascBtn;

    @FXML
    private Button buyBtn;

    @FXML
    private ImageView cartImg;

    @FXML
    private ListView<Medicine> cartListView;

    @FXML
    private Pane cartPane;

    @FXML
    private ImageView clos;

    @FXML
    private Button closeCart;

    @FXML
    private Button delBtn;

    @FXML
    private MenuItem descBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private ListView<Medicine> listViewOfMeds;

    @FXML
    private ImageView mainImage;

    @FXML
    private ImageView medsMainImage;

    @FXML
    private Label medsTitleLabel;

    @FXML
    private MenuItem nameBtn;

    @FXML
    private Button showMedBtn;

    @FXML
    private Label titleLabel;

    @FXML
    private HBox topHBox;

    @FXML
    void addToCart(ActionEvent event) {
        cartListView.setVisible(true);
        addToCartBtn.setOnAction(event1 -> {
            final Medicine selectedMedicine = listViewOfMeds.getSelectionModel().getSelectedItem();
            if(selectedMedicine.getStock()>0) {
                cartListView.getItems().add(selectedMedicine);
            }
            toBuy.addAll(cartListView.getItems());
        });
    }

    @FXML
    void hideCart(ActionEvent event) {
        cartListView.setVisible(false);
    }

    @FXML
    public void showMedsInListView(ActionEvent event) {

    }

    @FXML
    void sortMedsByName(ActionEvent event) {
        ObservableList<Medicine> meds = dbConnection.getAllMedicines();
        Collections.sort(meds);
        listViewOfMeds.setItems(meds);

    }

    @FXML
    void sortAscMeds(ActionEvent event) {
        Comparator<Medicine> ascCompare = new Comparator<>() {
            @Override
            public int compare(Medicine o1, Medicine o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                }
                return 1;
            }
        };

        ObservableList<Medicine> meds = dbConnection.getAllMedicines();
        meds.sort(ascCompare);
        listViewOfMeds.setItems(meds);
    }

    @FXML
    void sortDescMeds(ActionEvent event) {
        Comparator<Medicine> ascCompare = new Comparator<Medicine>() {
            @Override
            public int compare(Medicine o1, Medicine o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return 1;
                }
                return -1;
            }
        };

        ObservableList<Medicine> meds = dbConnection.getAllMedicines();
        meds.sort(ascCompare);
        listViewOfMeds.setItems(meds);
    }

    public void switchToMainScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:\\Users\\Bogdan.420\\IdeaProjects\\DrugStoreV2\\src\\main\\java\\gui\\fxml\\DrugStore.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,964,615);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToMedsScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:\\Users\\Bogdan.420\\IdeaProjects\\DrugStoreV2\\src\\main\\java\\gui\\fxml\\MedScene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,964,615);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public void switchToHealthScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:\\Users\\Bogdan.420\\IdeaProjects\\DrugStoreV2\\src\\main\\java\\gui\\fxml\\HealthScene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,964,615);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToVitaminScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:\\Users\\Bogdan.420\\IdeaProjects\\DrugStoreV2\\src\\main\\java\\gui\\fxml\\VitScene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,964,615);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToScScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:\\Users\\Bogdan.420\\IdeaProjects\\DrugStoreV2\\src\\main\\java\\gui\\fxml\\ScScene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,964,615);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void handleBuyButton() throws SQLException {
        for (Medicine med : toBuy) {
            dbConnection.buyProduct(med.getId());
            if(med.getStock()<1){
                listViewOfMeds.getItems().remove(med);
            }
        }
        cartListView.getItems().removeAll();
        cartListView.refresh();
        listViewOfMeds.refresh();

    }
    public void handleDeleteButton(){
        delBtn.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                final Medicine selectedMedicine = cartListView.getSelectionModel().getSelectedItem();
                cartListView.getItems().remove(selectedMedicine);
            }
        });
    }


    @Override
    public void initialize(URL location, ResourceBundle rs) {
        ObservableList<Medicine> meds = dbConnection.getAllMedicines();
        listViewOfMeds.setVisible(true);
        listViewOfMeds.setItems(meds);

    }
}



