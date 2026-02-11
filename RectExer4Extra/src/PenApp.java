//==========================================================
//	Simple Line Application in Java
//	두번의 클릭으로 선을 정의, 첫번째 클릭점은 선의 시작점이고 두번째 클릭점은 선의 끝점
//==========================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public Line theLine = null;
	public int startX, startY;
	public int endX, endY;
	public boolean firstClick = true;

	public static void main(String[ ] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}

	public PenApp() {
		setSize(600, 500);
		setTitle("Line 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

			if(e.getButton() == MouseEvent.BUTTON1) {
				if (firstClick) {
					startX = x;
					startY = y;
					firstClick = false;
				} else {
					endX = x;
					endY = y;
					
					if(theLine == null) {
						theLine = new Line(startX, startY, endX, endY);
					} else {
						theLine.startX = startX;
						theLine.startY = startY;
						theLine.endX = endX;
						theLine.endY = endY;
						theLine.color = Color.blue;
					}
					
					System.out.println("length of line: " + theLine.length());
					firstClick = true;
					repaint();
				}
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				if (theLine != null) {
					theLine.moveTo(x, y);
					theLine.color = Color.red;
					System.out.println("length of line: " + theLine.length());
					repaint();
				}
			}
		}
	}

	public void paint(Graphics g) {
		if(theLine != null)
			theLine.draw(g);
	}
}