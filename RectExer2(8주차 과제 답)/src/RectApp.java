//==============================================================
//	Simple Rectangle Application in Java
//==============================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	public Rect theRectangle = null;
	private boolean firstClick = true;
	private int firstX, firstY;

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
			
			if(firstClick) {//여기까지수정함
				firstX = x;
				firstY = y;
				firstClick = false;
			}
			else {
				theRectangle = new Rect(firstX, firstY, x, y);
				firstClick = true;
				repaint();
			}
		}
	}

	public void paint(Graphics g) {
		if(theRectangle != null)
			theRectangle.draw(g);
	}
}