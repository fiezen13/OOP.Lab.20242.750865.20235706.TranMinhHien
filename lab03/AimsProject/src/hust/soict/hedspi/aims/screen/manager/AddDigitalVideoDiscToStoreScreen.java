package hust.soict.hedspi.aims.screen.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{

	public AddDigitalVideoDiscToStoreScreen(Store store) {
		// TODO Auto-generated constructor stub
		super(store);
		
		JPanel directoryPanel = super.createSubPanel("Director");
		JPanel lengthPanel = super.createSubPanel("Length");
		
		super.centerPanel.add(directoryPanel);
		super.centerPanel.add(lengthPanel);
		
		btnAdd.addActionListener(new btnAddListener());
		super.setTitle("Add DVD");
	}

	public class btnAddListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String title = null, category = null, director = null;
			float cost = 0f; int length = 0;
			for(JTextField tf: tfs) {
				if(tf.getName().equals("Title")) {
					title = tf.getText();
				}
				if(tf.getName().equals("Cost")) {
					String costText = tf.getText();
	                if (!costText.isEmpty()) {
	                    cost = Float.parseFloat(costText);
	                }
				}
				if(tf.getName().equals("Category")) {
					category = tf.getText();
				}
				if(tf.getName().equals("Director")) {
					director = tf.getText();
				}
				if(tf.getName().equals("Length")) {
					String lengthText = tf.getText();
					if (!lengthText.isEmpty()) {
	                    length = Integer.parseInt(lengthText);
					}	
				}
			}
			
			if (title == null || category == null || director == null || cost <= 0 || length <= 0) {
                JOptionPane.showMessageDialog(null, "All fields must be filled correctly", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
			
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
			
			if (store.getItemsInStore().contains(dvd)) {
				JOptionPane.showMessageDialog(null, "The media's already in the store","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			store.addMedia(dvd);
			JOptionPane.showMessageDialog(null, "DVD is added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
