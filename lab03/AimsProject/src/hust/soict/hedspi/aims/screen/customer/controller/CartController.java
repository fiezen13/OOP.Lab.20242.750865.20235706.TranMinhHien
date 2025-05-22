package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.exception.PlayerException; // Import PlayerException
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
    private Cart cart;
    private Store store;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel; // This is the label for total cost

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            // Đảm bảo đường dẫn này chính xác đến file FXML của màn hình Store
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            if (this.cart == null || this.store == null) {
                System.err.println("CartController Error: Cart or Store is null. Cannot navigate to store.");
                Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Cannot load store: critical data missing.");
                errorAlert.showAndWait();
                return;
            }
            ViewStoreController viewStoreController = new ViewStoreController(this.cart, this.store);
            loader.setController(viewStoreController); 

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("AIMS Store"); // Đặt lại tiêu đề cho màn hình Store
            // stage.show(); // Không cần thiết nếu stage đã hiển thị, setScene là đủ
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error loading the store screen: " + e.getMessage());
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected error occurred: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));

        if (cart != null && cart.getItemsOrdered() != null) {
            tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
        }
        updateTotalCostLabel(); // Update total cost on initialization

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    private void updateTotalCostLabel() {
        if (cart != null && costLabel != null) {
            float total = cart.totalCost(); 
            costLabel.setText(String.format("%.2f $", total));
        } else if (costLabel != null) {
            costLabel.setText("0.00 $");
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media selectedItem = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedItem != null && cart != null) {
            try {
                cart.removeMedia(selectedItem); // Remove from the Cart object
                tblMedia.getItems().remove(selectedItem); // Remove from the TableView
                updateTotalCostLabel(); // Update the total cost label
            } catch (Exception e) { // Catch MediaNotFoundException or general Exception
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error removing media: " + e.getMessage());
                alert.showAndWait();
                e.printStackTrace();
            }
        } else if (selectedItem == null) {
             Alert alert = new Alert(Alert.AlertType.WARNING, "Please select an item to remove.");
             alert.showAndWait();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null && media instanceof Playable) {
            try {
                StringBuffer playInfo = ((Playable) media).play(); // Call play() and get StringBuffer
                Alert alert = new Alert(Alert.AlertType.INFORMATION, playInfo.toString());
                alert.setTitle("Playing Media");
                alert.setHeaderText("Now playing: " + media.getTitle());
                alert.showAndWait();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error playing media: " + e.getMessage());
                alert.showAndWait();
                e.printStackTrace();
            } catch (Exception e) {
                 Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected error occurred: " + e.getMessage());
                alert.showAndWait();
                e.printStackTrace();
            }
        } else if (media == null) {
             Alert alert = new Alert(Alert.AlertType.WARNING, "Please select an item to play.");
             alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "'" + media.getTitle() + "' is not playable.");
            alert.showAndWait();
        }
    }

    // Placeholder for Place Order button if you add it to FXML
    @FXML
    void btnPlaceOrderClicked(ActionEvent event) {
        if (cart != null && !cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order placed successfully! Total: " + String.format("%.2f $", cart.totalCost()));
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Your cart is empty. Cannot place order.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }
}