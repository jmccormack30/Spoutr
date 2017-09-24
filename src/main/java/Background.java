package main.java;

import javax.swing.ImageIcon;
import java.awt.Graphics;

/**
 * This class represents the Background for the App
 */
public class Background {

	private ImageIcon image;
	private int xPos;
	private int yPos;

	public Background(int x, int y) {
		image = new ImageIcon(getClass().getResource("images/logo.png"));
		xPos = x;
		yPos = y;
	}

	public void setImage(String path) {
		image = new ImageIcon(getClass().getResource(path));
	}

	public int getYPos() {
		return yPos;
	}

	public int getXPos() {
		return xPos;
	}

	public void draw(Graphics g) {
		image.paintIcon(null, g, xPos, yPos);
	}
}