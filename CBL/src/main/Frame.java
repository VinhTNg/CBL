package main;

import java.awt.*;

import javax.swing.*;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		GamePanel gamePanel = new GamePanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("CBL");
		frame.add(gamePanel);
		frame.pack();
//		frame.getContentPane().setBackground(Color.black);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
	}
}
