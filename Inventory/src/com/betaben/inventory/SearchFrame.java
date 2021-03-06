package com.betaben.inventory;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class SearchFrame extends JFrame {

	public static JPanel contentPane;
	private JButton button = new JButton();
	private JTextField textField;
	public static JScrollPane scrollPane;
	public static JPanel scrollPanel;
	private JLabel label;

	public SearchFrame() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(700, 100, 545, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("Search");
		button.setBounds(12, 82, 338, 60);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text = textField.getText();
				for(ItemPanel panels : Main.hashes.keySet()){
					if(Main.hashes.get(panels).getName().equals(text)){
						System.out.println("This item is in your inventory.");
						label.setText("This item is in your inventory.");
						scrollPanel.add(panels);
						refresh();
						break;
					} else {
						System.out.println("This item is not in your inventory.");
						label.setText("This item is not in your inventory.");
						scrollPanel.removeAll();
						refresh();
					}
				}
			}
		});
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(12, 13, 338, 60);
		contentPane.add(textField);
		textField.setColumns(10);

		scrollPanel = new JPanel();
		scrollPanel.setPreferredSize(new Dimension(141, 1000));
		scrollPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(362, 13, 151, 165);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(scrollPanel);
		contentPane.add(scrollPane);
		
		label = new JLabel("");
		label.setBounds(12, 154, 338, 16);
		contentPane.add(label);
		
		contentPane.getRootPane().setDefaultButton(button);
	}
	
	public void refresh(){
		
		scrollPanel.revalidate();
		scrollPanel.repaint();
		
		scrollPane.revalidate();
		scrollPane.repaint();
		
		contentPane.revalidate();
		contentPane.repaint();
		
	}
}
