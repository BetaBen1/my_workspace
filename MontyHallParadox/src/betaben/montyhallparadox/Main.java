package betaben.montyhallparadox;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Main extends JFrame {

	private JPanel contentPane;

	JToggleButton btnDoor1;
	JToggleButton btnDoor2;
	JToggleButton btnDoor3;
	JButton btnSubmit;
	
	public int selection;
	public int n;
	public int amountSelected = 0;
	public int goat;
	
	public Random rand = new Random();
	private JButton btnBegin;
	private JLabel display;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
		setBounds(100, 100, 450, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 160, 73, 0};
		gbl_contentPane.rowHeights = new int[]{64, 185, 75, 95, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnDoor1 = new JToggleButton("Door 1");
		btnDoor1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				selection = 1;
				btnDoor2.setSelected(false);
				btnDoor3.setSelected(false);
			}
		});
		
		btnBegin = new JButton("Begin");
		GridBagConstraints gbc_btnBegin = new GridBagConstraints();
		gbc_btnBegin.gridwidth = 3;
		gbc_btnBegin.insets = new Insets(0, 0, 5, 5);
		gbc_btnBegin.gridx = 0;
		gbc_btnBegin.gridy = 0;
		btnBegin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				findInt();
			}
		});
		contentPane.add(btnBegin, gbc_btnBegin);
		GridBagConstraints gbc_btnDoor1 = new GridBagConstraints();
		gbc_btnDoor1.anchor = GridBagConstraints.WEST;
		gbc_btnDoor1.insets = new Insets(0, 0, 5, 5);
		gbc_btnDoor1.gridx = 0;
		gbc_btnDoor1.gridy = 1;
		contentPane.add(btnDoor1, gbc_btnDoor1);
		
		btnDoor2 = new JToggleButton("Door 2");
		btnDoor2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				selection = 2;
				btnDoor1.setSelected(false);
				btnDoor3.setSelected(false);
			}
		});
		GridBagConstraints gbc_btnDoor2 = new GridBagConstraints();
		gbc_btnDoor2.insets = new Insets(0, 0, 5, 5);
		gbc_btnDoor2.gridx = 1;
		gbc_btnDoor2.gridy = 1;
		contentPane.add(btnDoor2, gbc_btnDoor2);
		
		btnDoor3 = new JToggleButton("Door 3");
		btnDoor3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				btnDoor1.setSelected(false);
				btnDoor2.setSelected(false);
			}
		});
		GridBagConstraints gbc_btnDoor3 = new GridBagConstraints();
		gbc_btnDoor3.insets = new Insets(0, 0, 5, 0);
		gbc_btnDoor3.anchor = GridBagConstraints.EAST;
		gbc_btnDoor3.gridx = 2;
		gbc_btnDoor3.gridy = 1;
		contentPane.add(btnDoor3, gbc_btnDoor3);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				runGame();
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 2;
		contentPane.add(btnSubmit, gbc_btnSubmit);
		
		display = new JLabel("");
		GridBagConstraints gbc_display = new GridBagConstraints();
		gbc_display.gridwidth = 3;
		gbc_display.insets = new Insets(0, 0, 0, 5);
		gbc_display.gridx = 0;
		gbc_display.gridy = 3;
		contentPane.add(display, gbc_display);
	
	}
	
	public void findInt(){
		n = rand.nextInt(3)+1;
		System.out.println("Correct Door: " + n);
		btnSubmit.setEnabled(true);
	}
	
	public void runGame(){
		amountSelected+=1;
		if(btnDoor1.isSelected()){
			selection = 1;
		}
		if(btnDoor2.isSelected()){
			selection = 2;
		}
		if(btnDoor3.isSelected()){
			selection = 3;
		}
		if(amountSelected==2){
			display.setText("The game is over.");
			btnSubmit.setEnabled(false);
			if(selection == n){
				display.setText("You have won!");
			}
			if(selection != n){
				display.setText("You have lost. The correct answer was " + n);
			}
			
		} else {
			if(selection == n){
				display.setText("You have won!!! The game is over.");
			}
			if(selection != n){
				goat = rand.nextInt(3)+1;
				while(goat==n || goat==selection){
					goat = rand.nextInt(3)+1;
					System.out.println(goat);
				}
				if(goat==1){
					btnDoor1.setBorder(BorderFactory.createLineBorder(Color.red, 1));
				}
				if(goat==2){
					btnDoor2.setBorder(BorderFactory.createLineBorder(Color.red, 1));
				}
				if(goat==3){
					btnDoor3.setBorder(BorderFactory.createLineBorder(Color.red, 1));
				}
				display.setText("You did not choose the correct door. You may chose the other door if you wish.");
			}
			if(selection == 0){
				display.setText("You must first choose a door.");
			}
		}
	}
	
}
