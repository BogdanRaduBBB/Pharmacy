
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pojo.SkinCare;

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
    private ObservableList<SkinCare> toBuy = FXCollections.observableArrayList();
    private boolean wasClicked;

    //Buttons
    @FXML
    private Button healthSceneBtn;

    @FXML
    private Button sknBtn;

    @FXML
    private Button vitBtn;

    @FXML
    private Button addToCartBtn;

    @FXML
    private MenuItem ascBtn;

    @FXML
    private Button buyBtn;

    @FXML
    private ImageView cartImg;

    @FXML
    public ListView<SkinCare> cartListView;

    @FXML
    private Pane cartPane;

    @FXML
    private ImageView clos;

    @FXML
    private Button showCartBtn;

    @FXML
    private Button closeCart;

    @FXML
    private Button delBtn;

    @FXML
    private MenuItem descBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private ListView<SkinCare> listViewOfSc;

    @FXML
    private ImageView mainImage;

    @FXML
    private ImageView ScMainImage;

    @FXML
    private Label scTitleLabel;

    @FXML
    private MenuItem nameBtn;

    @FXML
    private Button showMedBtn;

    @FXML
    private Label titleLabel;

    @FXML
    private HBox topHBox;

    @FXML
    private HBox btnsHBox;


    //Actions
    @FXML
    void showCart(ActionEvent event) {
        cartListView.setVisible(true);
    }

    @FXML
    void hideCart(ActionEvent event) {
        cartListView.setVisible(false);
        if (wasClicked) {
            cartListView.getItems().removeAll();
            cartListView.refresh();
        }
    }

    @FXML
    void sortscByName(ActionEvent event) {
        ObservableList<SkinCare> sc = dbConnection.getAllScProducts();
        Collections.sort(sc);
        listViewOfSc.setItems(sc);

    }

    @FXML
    void sortAscsc(ActionEvent event) {
        Comparator<SkinCare> ascCompare = new Comparator<>() {
            @Override
            public int compare(SkinCare o1, SkinCare o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                }
                return 1;
            }
        };

        ObservableList<SkinCare> sc = dbConnection.getAllScProducts();
        sc.sort(ascCompare);
        listViewOfSc.setItems(sc);
    }

    @FXML
    void sortDescsc(ActionEvent event) {
        Comparator<SkinCare> ascCompare = new Comparator<SkinCare>() {
            @Override
            public int compare(SkinCare o1, SkinCare o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return 1;
                }
                return -1;
            }
        };

        ObservableList<SkinCare> sc = dbConnection.getAllScProducts();
        sc.sort(ascCompare);
        listViewOfSc.setItems(sc);
    }

    @FXML
    public void handleBuyButton() throws SQLException {
        for (SkinCare med : toBuy) {
            dbConnection.buyProduct(med.getId());
            if (med.getStock() < 1) {
                listViewOfSc.getItems().remove(med);
            }
        }
        buyBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            wasClicked = true;
        });
        toBuy.removeAll();
        forceListRefreshOn(cartListView);
        forceListRefreshOn(listViewOfSc);
    }


    private void forceListRefreshOn(ListView<SkinCare> lsv) {
        ObservableList<SkinCare> items = lsv.getItems();
        lsv.setItems(null);
        lsv.setItems(items);
    }

    @FXML
    public void handleDeleteButton() {
        delBtn.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                final SkinCare selectedSkinCare = cartListView.getSelectionModel().getSelectedItem();
                cartListView.getItems().remove(selectedSkinCare);
            }
        });
    }

    @FXML
    void handleAddToCartBtn() {
        addToCartBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final SkinCare selectedSkinCare = listViewOfSc.getSelectionModel().getSelectedItem();
                if (selectedSkinCare.getStock() != 0) {
                    cartListView.getItems().add(selectedSkinCare);
                    toBuy.add(selectedSkinCare);
                }
            }

        });

    }

    //Switch between scenes
    @FXML
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

    @FXML
    public void switchToscScene(ActionEvent e) throws IOException {
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

    @FXML
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

    @FXML
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

    @Override
    public void initialize(URL location, ResourceBundle rs) {
        ObservableList<SkinCare> sc = dbConnection.getAllScProducts();
        listViewOfSc.setVisible(true);
        listViewOfSc.setItems(sc);

    }

    @FXML
    void initialize() {
        assert addToCartBtn != null : "fx:id=\"addToCartBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert ascBtn != null : "fx:id=\"ascBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert buyBtn != null : "fx:id=\"buyBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert cartImg != null : "fx:id=\"cartImg\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert cartListView != null : "fx:id=\"cartListView\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert cartPane != null : "fx:id=\"cartPane\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert clos != null : "fx:id=\"clos\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert closeCart != null : "fx:id=\"closeCart\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert delBtn != null : "fx:id=\"delBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert descBtn != null : "fx:id=\"descBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert healthSceneBtn != null : "fx:id=\"healthSceneBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert homeBtn != null : "fx:id=\"homeBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert listViewOfSc != null : "fx:id=\"listViewOfsc\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert mainImage != null : "fx:id=\"mainImage\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert scTitleLabel != null : "fx:id=\"scTitleLabel\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert nameBtn != null : "fx:id=\"nameBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert showMedBtn != null : "fx:id=\"showMedBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert sknBtn != null : "fx:id=\"sknBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert titleLabel != null : "fx:id=\"titleLabel\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert topHBox != null : "fx:id=\"topHBox\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert vitBtn != null : "fx:id=\"vitBtn\" was not injected: check your FXML file 'ScScene.fxml'.";
        assert btnsHBox != null : "fx:id=\"btnsHBox\" was not injected: check your FXML file 'ScScene.fxml'.";

    }
}



