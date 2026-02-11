// Rect class

import java.awt.Color;
import java.awt.Graphics;

public class Rect {
	// 필드
	private int upperLeftX;
	private int upperLeftY;
	private int lowerRightX;
	private int lowerRightY;

	// 생성자 오버로딩
	public Rect() {
		upperLeftX = 100;
		upperLeftY = 100;
		lowerRightX = 150;
		lowerRightY = 170;
	}
	public Rect(int ulx, int uly, int lrx, int lry) {
		upperLeftX = ulx;
		upperLeftY = uly;
		lowerRightX = lrx;
		lowerRightY = lry;
	}
	
	// 점근 메소드와 변경 메소드
	public int getUpperLeftX() {
		return upperLeftX;
	}
	public int getUpperLeftY() {
		return upperLeftY;
	}
	public int getLowerRightX() {
		return lowerRightX;
	}
	public int getLowerRightY() {
		return lowerRightY;
	}
	public void setUpperLeftX(int a) {
		upperLeftX = a;
	}
	public void setUpperLeftY(int a) {
		upperLeftY =a;
	}
	public void setLowerRightX(int a) {
		lowerRightX = a;
	}
	public void setLowerRightY(int a) {
		lowerRightY = a;
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
}