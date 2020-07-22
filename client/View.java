package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View implements ActionListener{
	
	private JFrame frame;
	private JPanel upperPanel, centerPanel, bottomPanel;
	private JLabel upperLabel;
	private JButton submit;
	private JTextField textField;
	private JMenuBar bar;
	private JMenu control, help;
	private JMenuItem exit, instruction;
	private JButton box1, box2, box3, box4, box5, box6, box7, box8, box9;
	
	/**
	 * a constructor to build up the view of the game
	 */
	public View() {
		setFrame();
		setMessagePanel();
		setDisplayPanel();
		setStartPanel();
	}
	
	/**
	 * setting up the frame for the game then this frame will be assigned with three panels
	 */
	private void setFrame() {
		frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 600);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		bar = new JMenuBar();
		control = new JMenu("Control");
		help = new JMenu("Help");
		exit = new JMenuItem("Exit");
		instruction = new JMenuItem("Instruction");
		instruction.addActionListener(e->{
			JOptionPane.showMessageDialog(instruction, "Some information about the game:\r\n" +
										"Criteria for a valid move:\r\n" +
										"-The move is not occupied by any mark.\r\n"+
										"-The move is made in the player's turn.\r\n"+
										"-The move is made within the 3x3 board.\r\n"+
										"The game would continue and switch among the opposite player until it reaches either one of the following conditions:\r\n"+
										"-Player 1 wins\r\n"+
										"-Player 2 wins\r\n"+
										"Draw\r\n");
		});
		control.add(exit);
		help.add(instruction);
		bar.add(control);
		bar.add(help);
		frame.setJMenuBar(bar);
		
	}
	
	/**
	 * the first panel which show up the command received from the server 
	 * and send out the message to the player
	 */
	private void setMessagePanel() {
		upperPanel = new JPanel();
		upperPanel.setSize(450, 20);
		upperPanel.setLocation(0, 0);
		upperPanel.setLayout(new BorderLayout());
		upperPanel.setBackground(Color.lightGray);
		upperLabel = new JLabel("Enter your player name...");
		upperPanel.add(upperLabel, BorderLayout.LINE_START);
		frame.add(upperPanel);
	}
	
	/**
	 * this will layout the Tic Tac Toe Board to player to play and 
	 * button will be available for the player to pick which box he is going to move
	 */
	private void setDisplayPanel() {
		centerPanel = new JPanel(new GridLayout(3,3));
		box1 = new JButton("1");
		box2 = new JButton("2");
		box3 = new JButton("3");
		box4 = new JButton("4");
		box5 = new JButton("5");
		box6 = new JButton("6");
		box7 = new JButton("7");
		box8 = new JButton("8");
		box9 = new JButton("9");
		centerPanel.add(box1);
		centerPanel.add(box2);
		centerPanel.add(box3);
		centerPanel.add(box4);
		centerPanel.add(box5);
		centerPanel.add(box6);
		centerPanel.add(box7);
		centerPanel.add(box8);
		centerPanel.add(box9);
		box1.setBackground(Color.white);
		box2.setBackground(Color.white);
		box3.setBackground(Color.white);
		box4.setBackground(Color.white);
		box5.setBackground(Color.white);
		box6.setBackground(Color.white);
		box7.setBackground(Color.white);
		box8.setBackground(Color.white);
		box9.setBackground(Color.white);
		centerPanel.setSize(450, 450);
		centerPanel.setLocation(0, 20);
		frame.setBackground(Color.white);
		frame.add(centerPanel);
	}
	
	/**
	 * the last panel for player to assign there own name
	 * this will also required to assign their name first to connect to the server
	 */
	private void setStartPanel() {
		bottomPanel = new JPanel();
		bottomPanel.setSize(450, 130);
		bottomPanel.setLocation(0, 470);
		bottomPanel.setBackground(Color.lightGray);
		textField = new JTextField(30);
		submit = new JButton("Submit");
		bottomPanel.add(textField);
		bottomPanel.add(submit);
		frame.add(bottomPanel);
	}
	
	/**
	 * return the textfield
	 * @return textfield
	 */
	public JTextField getTextField() {
		return textField;
	}
	
	/**
	 * to get the submit button to the client 
	 * @return	submit button
	 */
	public JButton getSubmit() {
		return submit;
	}
	
	/**
	 * to get the upperlabel which is layput the message from the server
	 * @return upperLabel
	 */
	public JLabel getUpperLabel() {
		return upperLabel;
	}
	
	/**
	 * there maybe some message need to pop for noticing the player
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * to return the exit button for add an Actionlistener
	 * @return exit button in the bar
	 */
	public JMenuItem getExit() {
		return exit;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * set the box from number to the corresponding chess(red cross or blue circle)
	 * @param chess
	 */
	public void setBox1(String chess){
		if(chess.equals("X")) {
			box1.setForeground(Color.red);
		}else {
			box1.setForeground(Color.blue);
		}
		box1.setFont(new Font("Arial", Font.PLAIN, 80));
		box1.setText(chess);
	}
	
	/**
	 * set the box from number to the corresponding chess(red cross or blue circle)
	 * @param chess
	 */
	public void setBox2(String chess){
		if(chess.equals("X")) {
			box2.setForeground(Color.red);
		}else {
			box2.setForeground(Color.blue);
		}
		box2.setFont(new Font("Arial", Font.PLAIN, 80));
		box2.setText(chess);
	}
	
	/**
	 * set the box from number to the corresponding chess(red cross or blue circle)
	 * @param chess
	 */
	public void setBox3(String chess){
		if(chess.equals("X")) {
			box3.setForeground(Color.red);
		}else {
			box3.setForeground(Color.blue);
		}
		box3.setFont(new Font("Arial", Font.PLAIN, 80));
		box3.setText(chess);
	}
	
	/**
	 * set the box from number to the corresponding chess(red cross or blue circle)
	 * @param chess
	 */
	public void setBox4(String chess){
		if(chess.equals("X")) {
			box4.setForeground(Color.red);
		}else {
			box4.setForeground(Color.blue);
		}
		box4.setFont(new Font("Arial", Font.PLAIN, 80));
		box4.setText(chess);
	}
	
	/**
	 * set the box from number to the corresponding chess(red cross or blue circle)
	 * @param chess
	 */
	public void setBox5(String chess){
		if(chess.equals("X")) {
			box5.setForeground(Color.red);
		}else {
			box5.setForeground(Color.blue);
		}
		box5.setFont(new Font("Arial", Font.PLAIN, 80));
		box5.setText(chess);
	}
	
	/**
	 * set the box from number to the corresponding chess(red cross or blue circle)
	 * @param chess
	 */
	public void setBox6(String chess){
		if(chess.equals("X")) {
			box6.setForeground(Color.red);
		}else {
			box6.setForeground(Color.blue);
		}
		box6.setFont(new Font("Arial", Font.PLAIN, 80));
		box6.setText(chess);
	}
	
	/**
	 * set the box from number to the corresponding chess(red cross or blue circle)
	 * @param chess
	 */
	public void setBox7(String chess){
		if(chess.equals("X")) {
			box7.setForeground(Color.red);
		}else {
			box7.setForeground(Color.blue);
		}
		box7.setFont(new Font("Arial", Font.PLAIN, 80));
		box7.setText(chess);
	}
	
	/**
	 * set the box from number to the corresponding chess(red cross or blue circle)
	 * @param chess
	 */
	public void setBox8(String chess){
		if(chess.equals("X")) {
			box8.setForeground(Color.red);
		}else {
			box8.setForeground(Color.blue);
		}
		box8.setFont(new Font("Arial", Font.PLAIN, 80));
		box8.setText(chess);
	}
	
	/**
	 * set the box from number to the corresponding chess(red cross or blue circle)
	 * @param chess
	 */
	public void setBox9(String chess){
		if(chess.equals("X")) {
			box9.setForeground(Color.red);
		}else {
			box9.setForeground(Color.blue);
		}
		box9.setFont(new Font("Arial", Font.PLAIN, 80));
		box9.setText(chess);
	}
	
	/**
	 * to return the box to add actionlistener later on
	 * @return box1 button
	 */
	public JButton getBox1() {
		return box1;
	}
	
	/**
	 * to return the box to add actionlistener later on
	 * @return box2 button
	 */
	public JButton getBox2() {
		return box2;
	}
	
	/**
	 * to return the box to add actionlistener later on
	 * @return box3 button
	 */
	public JButton getBox3() {
		return box3;
	}
	
	/**
	 * to return the box to add actionlistener later on
	 * @return box4 button
	 */
	public JButton getBox4() {
		return box4;
	}	
	
	/**
	 * to return the box to add actionlistener later on
	 * @return box5 button
	 */
	public JButton getBox5() {
		return box5;
	}
	
	/**
	 * to return the box to add actionlistener later on
	 * @return box6 button
	 */
	public JButton getBox6() {
		return box6;
	}
	
	/**
	 * to return the box to add actionlistener later on
	 * @return box7 button
	 */
	public JButton getBox7() {
		return box7;
	}
	
	/**
	 * to return the box to add actionlistener later on
	 * @return box8 button
	 */
	public JButton getBox8() {
		return box8;
	}
	
	/**
	 * to return the box to add actionlistener later on
	 * @return box9 button
	 */
	public JButton getBox9() {
		return box9;
	}
}
