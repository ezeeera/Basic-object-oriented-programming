//========================================================
//	Simple Rectangle Application in Java
//	사각형 내 왼쪽 버튼에 이동, 사각형 내 오른쪽 버튼에 가로 세로가 5픽셀씩 커짐
//	getter와 setter 사용
//========================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	public Rect theRectangle = null;

	public static void main(String[ ] args) {
		RectApp window = new RectApp();
		window.setVisible(true);
	}

	public RectApp() {
		setSize(600, 500);
		setTitle("Rect 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			// 마우스 왼쪽 버튼이면
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(theRectangle == null) {
					theRectangle = new Rect(x, y, x+70, y+50);
				}
				else {
					if(theRectangle.includes(x, y))
						theRectangle.moveTo(x, y);
				}
			}
			// 오른쪽 버튼에는 사각형의 가로, 세로 5씩 증가
			else if(e.getButton() == MouseEvent.BUTTON3) {
				if(theRectangle != null) {
					if(theRectangle.includes(x, y)) {
						int tempX = theRectangle.getLowerRightX() + 5;
						int tempY = theRectangle.getLowerRightY() + 5;
						theRectangle.setLowerRightX(tempX);
						theRectangle.setLowerRightY(tempY);
					}
				}
			}
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		if(theRectangle != null)
			theRectangle.draw(g);
	}
}