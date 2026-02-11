//==============================================================
//	Simple Rectangle Application in Java
// 오른쪽 마우스 누를 때 마다 90도씩 회전 10.28
// 중심점 찾고 그 중심으로 돌기.
// if문 없으면 프로그램 죽음
//이건 외부접근으로 돌리는거
//사각형개체가 스스로 할 수 있는 기능.-그 기능을 스스로 할 수 있는게 객체다.>>그럼스스로로테이트할수있는거?
//==============================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	public Rect theRectangle = null;
	public int upperLeftX, upperLeftY;
	public int lowerRightX, lowerRightY;
	public boolean firstClick = true;
	public static void main(String[] args) {
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

			if (e.getButton() == MouseEvent.BUTTON1) {
				if (firstClick) {
					upperLeftX = x;
					upperLeftY = y;
					firstClick = false;
				} else {
					lowerRightX = x;
					lowerRightY = y;
					theRectangle = new Rect(upperLeftX, upperLeftY, lowerRightX, lowerRightY);
					firstClick = true;
					repaint();
				}
			} else {
				if(theRectangle != null) {
					int width = theRectangle.lowerRightX - theRectangle.upperLeftX;
					int heigth = theRectangle.lowerRightY - theRectangle.upperLeftY;
					int centerX = theRectangle.upperLeftX + width/2;
					int centerY = theRectangle.upperLeftY + heigth/2;
					theRectangle.upperLeftX = centerX - heigth/2;
					theRectangle.upperLeftY = centerY - width/2;
					theRectangle.lowerRightX = centerX + heigth/2;
					theRectangle.lowerRightY = centerY + width/2;
				    repaint();
				}
			}
		}
	}
		
		public void paint(Graphics g) {
		if(theRectangle != null)
			theRectangle.draw(g);
		}
		}