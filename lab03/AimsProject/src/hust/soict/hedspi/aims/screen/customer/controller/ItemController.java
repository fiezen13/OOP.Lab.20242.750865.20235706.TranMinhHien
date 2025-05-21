package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
    public ItemController(Cart cart) {
    	this.cart = cart;
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {

    }

    @FXML
    void btnPlayClicked(ActionEvent event) {

    }

	
	private Media media;
	public void setData(Media media) {
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost()+"$");
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
		}
	}
}
