package betaben.inventoryv2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	static Main frame;
	
	public static JPanel contentPane;

	static JPanel scrollPanel;
	static JScrollPane scrollPane;
	JLabel lblInventory;
	JLabel lblItemName;
	JLabel lblItemPrice;
	JLabel lblAddItemDisplay;
	JButton btnAddItem;
	JTextField nameTextField;
	JTextField priceTextField;
	JButton btnSearch;
	JTextField searchTextField;
	JLabel lblSearchDisplay;
	
	public static String nameText;
	public static Double priceText;
	
	public static HashMap<ItemPanel, Item> hashes = new HashMap<ItemPanel, Item>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(5, 113, 269, 29);
		btnAddItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String vowels = "aeiou";
				nameText = nameTextField.getText();
				Item item = new Item(nameText, priceText);
				if(vowels.indexOf(Character.toLowerCase(nameText.charAt(0))) != -1){
					lblAddItemDisplay.setText("<html>An " + nameText + " was added to your inventory.<html>");
				} else {
					lblAddItemDisplay.setText("<html>A " + nameText + " was added to your inventory.<html>");
				} if(priceTextField.getText().isEmpty()){
					priceText = 0.00;
				} else {
					priceText = Double.parseDouble(priceTextField.getText());
				}
				ItemPanel panel = new ItemPanel(scrollPanel, nameText, "$" + priceText);
				ItemPanel.yPos += 75;
				scrollPanel.add(panel);
				
				hashes.put(panel, item);
				
				nameTextField.setText("");
				priceTextField.setText("");
			
				System.out.println("\nItem Name: \tItem Price:");
				for(ItemPanel panels : hashes.keySet()){
					System.out.println(hashes.get(panels).getName() + "\t\t $" + hashes.get(panels).getPrice());
				}
					
				refresh();
			}
		});
		contentPane.add(btnAddItem);
		
		lblItemName = new JLabel("Item Name:");
		lblItemName.setBounds(5, 5, 72, 16);
		contentPane.add(lblItemName);
		
		lblInventory = new JLabel("Inventory:");
		lblInventory.setBounds(279, 5, 166, 16);
		contentPane.add(lblInventory);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(5, 26, 269, 26);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		scrollPanel = new JPanel();
		scrollPanel.setPreferredSize(new Dimension(141, 1000));
		scrollPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 26, 166, 269);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(scrollPanel);
		contentPane.add(scrollPane);
		
		lblItemPrice = new JLabel("Item Price:");
		lblItemPrice.setBounds(5, 57, 66, 16);
		contentPane.add(lblItemPrice);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(5, 78, 269, 26);
		contentPane.add(priceTextField);
		priceTextField.setColumns(10);
		
		lblAddItemDisplay = new JLabel("");
		lblAddItemDisplay.setBounds(5, 133, 269, 40);
		contentPane.add(lblAddItemDisplay);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(5, 166, 269, 26);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);
		
		lblSearchDisplay = new JLabel("");
		lblSearchDisplay.setBounds(5, 269, 269, 29);
		contentPane.add(lblSearchDisplay);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(5, 193, 269, 64);
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text = searchTextField.getText();
				for(ItemPanel panel : hashes.keySet()){
//					System.out.println(hashes.get(panel).getName());
					if(hashes.get(panel).getName().equals(text)){
						lblSearchDisplay.setText("In stock!");
						refresh();
						break;
					} else {
						lblSearchDisplay.setText("Out of stock.");
						refresh();
					}
				}
			}
		});
		contentPane.add(btnSearch);
		
		contentPane.getRootPane().setDefaultButton(btnAddItem);
		
		runThread();
		
	}
	
	public void runThread(){
		Thread thread = new Thread(){
			@Override
			public void run(){
				while(true){
					if(nameTextField.getText().isEmpty() || priceTextField.getText().matches(".*[a-z].*") || priceTextField.getText().matches(".*[A-Z].*")){
						if(priceTextField.getText().matches(".*[a-z].*") || priceTextField.getText().matches(".*[A-Z].*")){
							priceTextField.setBackground(Color.red);
							btnAddItem.setEnabled(false);
						} else {
							priceTextField.setBackground(Color.white);
							btnAddItem.setEnabled(false);
						}
					} else {
						btnAddItem.setEnabled(true);
					}
					try{
						sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();	
	}	
	
	public void refresh(){
		scrollPane.revalidate();
		scrollPane.repaint();
		scrollPanel.revalidate();
		scrollPanel.repaint();
		contentPane.revalidate();
		contentPane.repaint();
	}
}
