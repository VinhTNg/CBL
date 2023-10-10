package main;

import javax.swing.*;

import java.awt.*;

public class GamePanel extends JPanel{
	final int originalTile = 16;
	final int scale = 3;
	final int tile = originalTile * scale;
	final int screenCol = 16;
	final int screenRow = 9;
	final int screenWidth = screenCol * tile;
	final int screenHeight = screenRow * tile;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.gray);
		this.setDoubleBuffered(true);
	}
}
