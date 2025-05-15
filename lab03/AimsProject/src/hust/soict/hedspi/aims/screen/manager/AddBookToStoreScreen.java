package hust.soict.hedspi.aims.screen.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
	
	public AddBookToStoreScreen(Store store) {
		// TODO Auto-generated constructor stub
		super(store);
		
		JPanel lstAuthors = super.createSubPanel("Authors");
		super.centerPanel.add(lstAuthors);
		
		btnAdd.addActionListener(new btnAddListener());
		super.setTitle("Add Book");
	}

	private class btnAddListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String title = null, category = null, authors = null;
			float cost = 0;
			ArrayList<String> authorsList = new ArrayList<>();
			
			for(JTextField tf : tfs) {
				if(tf.getName().equals("Title")) {
					title = tf.getText();
				}
				if(tf.getName().equals("Category")) {
					category = tf.getText();
				}
				if(tf.getName().equals("Cost")) {
					String costText = tf.getText();
					if(!costText.isEmpty()) {
						cost = Float.parseFloat(costText);
					}
				}
				if(tf.getName().equals("Authors")) {
					authors = tf.getText();
				}
			}
			
			//xử lý chuỗi tác giả
			if(authors != null && !authors.isEmpty()) {
				String[] authorNames = authors.split(",");
				for(String name : authorNames) {
					authorsList.add(name);
				}
			}
			
			if(title == null || category == null || cost <= 0 ||authorsList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "All fields must be filled correctly", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			Book b = new Book(title, category, cost);
			b.setAuthors(authorsList);
			
			if(store.getItemsInStore().contains(b)) {
				JOptionPane.showMessageDialog(null, "The Media's already in the store", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			store.addMedia(b);
			JOptionPane.showMessageDialog(null, "Book is added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
