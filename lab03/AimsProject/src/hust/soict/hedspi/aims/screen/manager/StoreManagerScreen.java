package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	private Store store;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem viewStoreMenu = new JMenuItem("View Store");
		menu.add(viewStoreMenu);
		viewStoreMenu.addActionListener(new btnMenuListener());
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBookMenu = new JMenuItem("Add Book");
		JMenuItem addCDMenu = new JMenuItem("Add CD");
		JMenuItem addDVDMenu = new JMenuItem("Add DVD");
		
		smUpdateStore.add(addBookMenu);
		smUpdateStore.add(addCDMenu);
		smUpdateStore.add(addDVDMenu);
		menu.add(smUpdateStore);
		
		addBookMenu.addActionListener(new btnMenuListener());
		addCDMenu.addActionListener(new btnMenuListener());
		addDVDMenu.addActionListener(new btnMenuListener());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50)); //giữ nguyên font chữ thường, không in nghiêng, hoa, đặt cỡ chữ bằng 50
		title.setForeground(Color.cyan);
		
		header.add(Box.createRigidArea(new Dimension(10,10))); // Tạo ra một khoảng đệm (padding) hoặc lề (margin) cố định 10x10 pixel ở đầu bên trái
		header.add(title);
		header.add(Box.createHorizontalGlue());  //Chiếm lấy toàn bộ không gian còn lại theo chiều ngang
		header.add(Box.createRigidArea(new Dimension(10, 10))); //Tạo khoảng đệm bên phải
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public StoreManagerScreen(Store store) {
		// TODO Auto-generated constructor stub
		this.store = store;

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class btnMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			JFrame S = null;
			if(command.equals("Add DVD")) {
				S = new AddDigitalVideoDiscToStoreScreen(store);
				S.setVisible(true);
				S.setLocationRelativeTo(null);
			} else if (command.equals("Add CD")) {
				S = new AddCompactDiscToStoreScreen(store);
				S.setVisible(true);
				S.setLocationRelativeTo(null);
			} else if (command.equals("Add Book")) {
				S = new AddBookToStoreScreen(store);
				S.setVisible(true);
				S.setLocationRelativeTo(null);
			} else if (command.equals("View Store")) {
				S = new StoreManagerScreen(store);
			}
			
			if(S != null) {
				StoreManagerScreen.this.dispose();
			}
		}
	}

	public static void main(String[] args) {
		new StoreManagerScreen(new Store());
	}
}
