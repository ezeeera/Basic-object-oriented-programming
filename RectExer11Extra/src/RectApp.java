import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	final public int COUNT = 10;
	public Rect[] rects;
	public int rectCount = 0;
	public int upperLeftX, upperLeftY, lowerRightX, lowerRightY;
	public boolean firstClick = true;
	public Rect selectedRect = null;

	public static void main(String[] args) {
		RectApp window = new RectApp();
		window.setVisible(true);
	}

	public RectApp() {
		setSize(600, 00);
		setTitle("Rect ÀÀ¿ë");
		addMouseListener(new MouseKeeper());
		rects = new Rect[COUNT];
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
					if (rectCount < COUNT) {
						rects[rectCount] = new Rect(upperLeftX, upperLeftY, lowerRightX, lowerRightY);
						rectCount++;
						updateRanks();
						repaint();
					}
					firstClick = true;
				}
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				if (selectedRect == null) {
					for (int i = rectCount - 1; i >= 0; i--) {
						if (rects[i].includes(x, y)) {
							selectedRect = rects[i];
							selectedRect.color = Color.red;
							repaint();
							break;
						}
					}
				} else {
					selectedRect.moveTo(x, y);
					selectedRect.color = Color.blue;
					selectedRect = null;
					updateRanks();
					repaint();
				}
			}
		}
	}

	public void updateRanks() {
		for (int i = 0; i < rectCount; i++) {
			rects[i].rank = 1;
			for (int j = 0; j < rectCount; j++) {
				if (rects[i].area() < rects[j].area()) {
					rects[i].rank++;
				}
			}
		}
	}

	public void paint(Graphics g) {
		for (int i = 0; i < rectCount; i++) {
			rects[i].draw(g);

			if (rects[i] == selectedRect) {
				g.setColor(Color.red);
			} else {
				g.setColor(Color.blue);
			}

			g.drawString(String.valueOf(rects[i].rank), rects[i].upperLeftX + 5, rects[i].upperLeftY - 5);
		}
	}

}
