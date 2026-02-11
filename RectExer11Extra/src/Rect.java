// Rect class

import java.awt.Color;
import java.awt.Graphics;

public class Rect{
	
	public int upperLeftX;
	public int upperLeftY;
	public int lowerRightX;
	public int lowerRightY;
	public Color color;
	public int rank;
	
	
	public Rect(int ulx, int uly, int lrx, int lry) {
		upperLeftX = ulx;
		upperLeftY = uly;
		lowerRightX = lrx;
		lowerRightY = lry;
		color = Color.blue;
		rank = 1;
	}
	
	
	public void moveTo(int ulx, int uly) {
		int width = lowerRightX - upperLeftX;
		int height = lowerRightY - upperLeftY;
		upperLeftX = ulx;
		upperLeftY = uly;
		lowerRightX = ulx + width;
		lowerRightY = uly + height;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		int width = lowerRightX - upperLeftX;
		int height = lowerRightY - upperLeftY;
		g.clearRect(upperLeftX, upperLeftY, width, height);
		g.drawRect(upperLeftX, upperLeftY, width, height);
	}
	
	public boolean includes(int x, int y) {
		if((upperLeftX<x) && (lowerRightX>x))
			if ((upperLeftY < y) && (lowerRightY > y))
				return true;
		return false;
	}
	
	public int area() {
		return (lowerRightX - upperLeftX) * (lowerRightY - upperLeftY);
	}
}
