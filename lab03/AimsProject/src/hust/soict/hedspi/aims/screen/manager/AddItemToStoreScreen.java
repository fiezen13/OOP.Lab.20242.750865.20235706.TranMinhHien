package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame{
	Store store;
	JPanel centerPanel;
	JButton btnAdd = new JButton("Add");
	
	//Khi ấn Add, cần lấy tất cả dữ liệu user đã nhập vào các trường
	ArrayList<JTextField> tfs = new ArrayList<JTextField>(); //quản lý các trường nhập liệu
	
	public AddItemToStoreScreen(Store store) {
		// TODO Auto-generated constructor stub
		this.store = store;
		
		this.setSize(1024, 768);
		this.setLayout(new BorderLayout());
		
		this.add(createNorth(), BorderLayout.NORTH);
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPanel.add(btnAdd);
		btnPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(btnPanel, BorderLayout.SOUTH);
		
		centerPanel = createCenter();
		this.add(centerPanel, BorderLayout.CENTER);
		
		this.setLocationRelativeTo(null);  //đặt đối tượng nằm ở trung tâm
		this.setVisible(true);
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createSubPanel(String text) {
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.X_AXIS));
		JTextField tf = new JTextField(30);
		tf.setName(text); //phân biệt các TextField khác nhau khi duyệt tfs, không phải để hiển thị cho user
		tfs.add(tf);
		tf.setPreferredSize(new Dimension(200, 25)); //thiết lập kích thước "mong muốn"(kích thước thật vẫn do LayoutManger quyết định)
		//cố gắng ép max min Size về cùng kích thước này
		tf.setMaximumSize(new Dimension(200,25));
		tf.setMinimumSize(new Dimension(200, 25));
		
		JLabel lbTextField = new JLabel(text);
		lbTextField.setPreferredSize(new Dimension(60, 60));
		lbTextField.setMaximumSize(new Dimension(60, 60));
		lbTextField.setMinimumSize(new Dimension(60, 60));
		
		subPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		subPanel.add(lbTextField);
		subPanel.add(tf);
		
		return subPanel;
	}
	
	//tận dụng các trường thông tin chung của Book, CD và DVD
	JPanel createCenter() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JPanel titlePanel = createSubPanel("Title");
		JPanel categoryPanel = createSubPanel("Category");
		JPanel costPanel = createSubPanel("Cost");
		
		centerPanel.add(titlePanel);
		centerPanel.add(costPanel);
		centerPanel.add(categoryPanel);
		
		return centerPanel;
	}
	
	//Vẫn cần Menu Options và View Store để user quay lại trang trước trong
	//trường hợp không muốn thêm sản phẩm nữa, hoặc để sau này mở rộng thanh menu
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem viewStoreMenu = new JMenuItem("View Store");
		menu.add(viewStoreMenu);
		viewStoreMenu.addActionListener(new btnMenuListener());
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	private class btnMenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new StoreManagerScreen(store);
			dispose();
		}
	}
}
