package com.betaben.inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	JLabel lbldisplay;
	JButton btnAddItem;
	JTextField nameTextField;
	JTextField priceTextField;
//	JRadioButton rdbtnDarkMode;
	JButton btnSearch;
	
	public static String nameText;
	public static Double priceText;
	
	//public static Library library = new Library();
	
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{274, 141, 0};
		gbl_contentPane.rowHeights = new int[]{16, 26, 16, 26, 45, 0, 44, 47, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String vowels = "aeiou";
				nameText = nameTextField.getText();
				if(priceTextField.getText().isEmpty()){
					priceText = 0.00;
				} else {
					priceText = Double.parseDouble(priceTextField.getText());
				}
				Item item = new Item(nameText, priceText);
//				library.addItem(item);
				if(vowels.indexOf(Character.toLowerCase(nameText.charAt(0))) != -1){
					lbldisplay.setText("<html>An " + nameText + " was added to your inventory.<html>");
				} else {
					lbldisplay.setText("<html>A " + nameText + " was added to your inventory.<html>");
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
				
				scrollPanel.revalidate();
				scrollPanel.repaint();
				
				scrollPane.revalidate();
				scrollPane.repaint();
				
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		lblItemName = new JLabel("Item Name:");
		GridBagConstraints gbc_lblItemName = new GridBagConstraints();
		gbc_lblItemName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblItemName.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName.gridx = 0;
		gbc_lblItemName.gridy = 0;
		contentPane.add(lblItemName, gbc_lblItemName);
		
		lblInventory = new JLabel("Inventory:");
		GridBagConstraints gbc_lblInventory = new GridBagConstraints();
		gbc_lblInventory.anchor = GridBagConstraints.NORTH;
		gbc_lblInventory.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblInventory.insets = new Insets(0, 0, 5, 0);
		gbc_lblInventory.gridx = 1;
		gbc_lblInventory.gridy = 0;
		contentPane.add(lblInventory, gbc_lblInventory);
		
		nameTextField = new JTextField();
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.anchor = GridBagConstraints.NORTH;
		gbc_nameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nameTextField.gridx = 0;
		gbc_nameTextField.gridy = 1;
		contentPane.add(nameTextField, gbc_nameTextField);
		nameTextField.setColumns(10);
		
		scrollPanel = new JPanel();
		scrollPanel.setPreferredSize(new Dimension(141, 1000));
		scrollPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(scrollPanel);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
//		rdbtnDarkMode = new JRadioButton("Dark Mode");
		
		lblItemPrice = new JLabel("Item Price:");
		GridBagConstraints gbc_lblItemPrice = new GridBagConstraints();
		gbc_lblItemPrice.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblItemPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemPrice.gridx = 0;
		gbc_lblItemPrice.gridy = 2;
		contentPane.add(lblItemPrice, gbc_lblItemPrice);
		
		priceTextField = new JTextField();
		GridBagConstraints gbc_priceTextField = new GridBagConstraints();
		gbc_priceTextField.anchor = GridBagConstraints.NORTH;
		gbc_priceTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_priceTextField.insets = new Insets(0, 0, 5, 5);
		gbc_priceTextField.gridx = 0;
		gbc_priceTextField.gridy = 3;
		contentPane.add(priceTextField, gbc_priceTextField);
		priceTextField.setColumns(10);
		
		lbldisplay = new JLabel("");
		GridBagConstraints gbc_lbldisplay = new GridBagConstraints();
		gbc_lbldisplay.fill = GridBagConstraints.BOTH;
		gbc_lbldisplay.insets = new Insets(0, 0, 5, 5);
		gbc_lbldisplay.gridx = 0;
		gbc_lbldisplay.gridy = 4;
		contentPane.add(lbldisplay, gbc_lbldisplay);
		
		btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 0;
		gbc_btnSearch.gridy = 5;
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SearchFrame searchFrame = new SearchFrame();
			}
		});
		contentPane.add(btnSearch, gbc_btnSearch);
		
//		GridBagConstraints gbc_rdbtnDarkMode = new GridBagConstraints();
//		gbc_rdbtnDarkMode.anchor = GridBagConstraints.NORTHWEST;
//		gbc_rdbtnDarkMode.insets = new Insets(0, 0, 5, 5);
//		gbc_rdbtnDarkMode.gridx = 0;
//		gbc_rdbtnDarkMode.gridy = 6;
//		contentPane.add(rdbtnDarkMode, gbc_rdbtnDarkMode);
		
		GridBagConstraints gbc_btnAddItem = new GridBagConstraints();
		gbc_btnAddItem.anchor = GridBagConstraints.SOUTH;
		gbc_btnAddItem.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddItem.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddItem.gridx = 0;
		gbc_btnAddItem.gridy = 7;
		contentPane.add(btnAddItem, gbc_btnAddItem);
		
		contentPane.getRootPane().setDefaultButton(btnAddItem);
		
		runThread();
		
	}
	
	public void runThread(){
		Thread thread = new Thread(){
			@Override
			public void run(){
				while(true){
//					if(rdbtnDarkMode.isSelected()){
//						contentPane.setBackground(Color.darkGray);
//						rdbtnDarkMode.setForeground(Color.white);
//						lblInventory.setForeground(Color.white);
//						lbldisplay.setForeground(Color.white);
//						lblItemName.setForeground(Color.white);
//						lblItemPrice.setForeground(Color.white);
//						nameTextField.setBackground(Color.lightGray);
//						priceTextField.setBackground(Color.lightGray);
//						scrollPanel.setBackground(Color.lightGray);
//					}else{
//						contentPane.setBackground(Color.lightGray);
//						rdbtnDarkMode.setForeground(Color.black);
//						lblInventory.setForeground(Color.black);
//						lbldisplay.setForeground(Color.black);
//						lblItemName.setForeground(Color.black);
//						lblItemPrice.setForeground(Color.black);
//						nameTextField.setBackground(Color.white);
//						priceTextField.setBackground(Color.white);
//						scrollPanel.setBackground(Color.white);
//					}
					if(nameTextField.getText().isEmpty()){
						btnAddItem.setEnabled(false);
					} else {
						btnAddItem.setEnabled(true);
					}
					try{
						sleep(150);
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
				}
			}
		};
		thread.start();	
	}	
}
