package betaben.montyhallparadox;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;

	JToggleButton btnDoor1;
	JToggleButton btnDoor2;
	JToggleButton btnDoor3;
	JButton btnSubmit;
	
	public int selection;
	
	public Random rand = new Random();

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 160, 73, 0};
		gbl_contentPane.rowHeights = new int[]{185, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnDoor1 = new JToggleButton("Door 1");
		btnDoor1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				selection = 1;
				btnDoor2.setSelected(false);
				btnDoor3.setSelected(false);
			}
		});
		btnDoor1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnDoor1 = new GridBagConstraints();
		gbc_btnDoor1.anchor = GridBagConstraints.WEST;
		gbc_btnDoor1.insets = new Insets(0, 0, 5, 5);
		gbc_btnDoor1.gridx = 0;
		gbc_btnDoor1.gridy = 0;
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
		gbc_btnDoor2.gridy = 0;
		contentPane.add(btnDoor2, gbc_btnDoor2);
		
		btnDoor3 = new JToggleButton("Door 3");
		btnDoor3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				selection = 3;
				btnDoor1.setSelected(false);
				btnDoor2.setSelected(false);
			}
		});
		GridBagConstraints gbc_btnDoor3 = new GridBagConstraints();
		gbc_btnDoor3.insets = new Insets(0, 0, 5, 0);
		gbc_btnDoor3.anchor = GridBagConstraints.EAST;
		gbc_btnDoor3.gridx = 2;
		gbc_btnDoor3.gridy = 0;
		contentPane.add(btnDoor3, gbc_btnDoor3);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				runGame();
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 1;
		contentPane.add(btnSubmit, gbc_btnSubmit);
	
//		runThread();
	
	}
	
	public void runGame(){
		int n = rand.nextInt(3)+1;
		System.out.println("Correct Door: " + n);
		System.out.println("Your Choice: " + selection);
		if(selection == n){
			System.out.println("You chose the correct door.");
		} 
		if(selection != n){
			System.out.println("You did not choose the correct door.");
		} else {
			System.out.println("You must first choose a door.");
		}
	}

}
