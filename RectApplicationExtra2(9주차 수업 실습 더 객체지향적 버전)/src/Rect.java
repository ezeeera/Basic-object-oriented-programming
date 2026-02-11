// Rect class

import java.awt.Color;
import java.awt.Graphics;

public class Rect {
	// 필드
	public int upperLeftX;
	public int upperLeftY;
	public int lowerRightX;
	public int lowerRightY;

	// 생성자
	public Rect(int ulx, int uly, int lrx, int lry) {
		upperLeftX = ulx;
		upperLeftY = uly;
		lowerRightX = lrx;
		lowerRightY = lry;
	}
	
	// 메소드
	public void moveTo(int ulx, int uly) {
		int width = lowerRightX - upperLeftX;
		int height = lowerRightY - upperLeftY;
		upperLeftX = ulx;
		upperLeftY = uly;
		lowerRightX = ulx + width;
		lowerRightY = uly + height;
	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		int width = lowerRightX - upperLeftX;
		int height = lowerRightY - upperLeftY;
		g.drawRect(upperLeftX, upperLeftY, width, height);
	}
	
	public boolean includes(int x, int y) {
		if((upperLeftX<x) && (lowerRightX>x))
			if((upperLeftY<y) && (lowerRightY>y))
				return true;
		return false;
	}
	
	public void rotate() {
		int width = lowerRightX - upperLeftX;
		int height = lowerRightY - upperLeftY;
		int centerX = upperLeftX + width/2;
		int centerY = upperLeftY + height/2;
		upperLeftX = centerX - height/2;
		upperLeftY = centerY - width/2;
		lowerRightX = centerX + height/2;
		lowerRightY = centerY + width/2;
	}
}