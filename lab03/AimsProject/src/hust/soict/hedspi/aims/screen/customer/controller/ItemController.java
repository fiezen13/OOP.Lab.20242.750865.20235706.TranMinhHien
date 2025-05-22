package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import hust.soict.hedspi.aims.exception.*; 

public class ItemController {
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    private Cart cart;
    private Media media; 

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (this.media == null) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Media item is not available.");
            errorAlert.showAndWait();
            return;
        }
        if (this.cart == null) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Cart is not initialized. Cannot add media.");
            errorAlert.showAndWait();
            return;
        }

        try {
            cart.addMedia(media); 
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "'" + media.getTitle() + "' added successfully to cart!");
            successAlert.showAndWait();
        } catch (LimitExceededException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            errorAlert.showAndWait();
            e.printStackTrace();
        } catch (Exception e) { 
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "An unexpected error occurred while adding to cart: " + e.getMessage());
            errorAlert.showAndWait();
            e.printStackTrace();
        }
    }


    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (this.media == null) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Media item is not available to play.");
            errorAlert.showAndWait();
            return;
        }

        if (!(media instanceof Playable)) {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING, "'" + media.getTitle() + "' is not playable.");
            errorAlert.showAndWait();
            return;
        }

        try {
            StringBuffer playInfoBuffer = ((Playable) media).play();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, playInfoBuffer.toString());
            alert.showAndWait();

        } catch (PlayerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error playing media: " + e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        } catch (Exception e) { 
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "An unexpected error occurred while trying to play: " + e.getMessage());
            errorAlert.showAndWait();
            e.printStackTrace();
        }
    }

    public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + " $");
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
    	}
    }
}