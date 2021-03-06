package com.betaben.inventory;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.MinguoChronology;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ItemPanel extends JPanel {

	JLabel lblNameText;
	JLabel lblPriceText;
	JButton btnRemove;
	
	public static int pos;
	public static int yPos;
	private JPanel panel;
	
	public ItemPanel(JPanel panel, String nameText, String priceText) {
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setBounds(0, yPos, 100, 70);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.panel = panel;
		
		lblNameText = new JLabel(nameText);
		add(lblNameText);
		
		lblPriceText = new JLabel(priceText);
		add(lblPriceText);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove();
			}
		});
		add(btnRemove);
	}

	public void remove(){
		int oldPos = panel.getY();
		panel.remove(this);
		Main.hashes.remove(this);
		//Main.library.removeItem(Main.hashes.geasdft(this));
		System.out.println("\nItem Name: \tItem Price:");
		for(ItemPanel panels : Main.hashes.keySet()){
			if(panels.getY()>oldPos){
				panels.setBounds(panels.getX(), panels.getY()-75, panels.getWidth(), panels.getHeight());
			}
			System.out.println(Main.hashes.get(panels).getName() + "\t\t $" + Main.hashes.get(panels).getPrice());
		}
		yPos -= 75;
		SearchFrame.scrollPanel.removeAll();
		refresh();
	}
	
	public void refresh(){
		Main.scrollPanel.revalidate();
		Main.scrollPanel.repaint();
		
		Main.scrollPane.revalidate();
		Main.scrollPane.repaint();
		
		Main.contentPane.revalidate();
		Main.contentPane.repaint();
		
		SearchFrame.scrollPanel.revalidate();
		SearchFrame.scrollPanel.repaint();
		
		SearchFrame.scrollPane.revalidate();
		SearchFrame.scrollPane.repaint();
		
		SearchFrame.contentPane.revalidate();
		SearchFrame.contentPane.repaint();
	}
	
}
