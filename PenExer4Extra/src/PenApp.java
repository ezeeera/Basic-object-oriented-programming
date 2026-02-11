//=========================================================================
//	Simple Pen Application in Java
//	오른쪽 마우스 클릭에는 직전 선을 지움
//	이어지는 왼쪽 버튼 클릭에는 지운 선의 시작점에서 클릭점까지 선을 그림
//	java.awt.Point 사용
//=========================================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public Point oldPoint = null;
	public Point newPoint = null;
	public boolean redPen = false;

	public static void main(String[ ] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}
	
	public PenApp() {
		setSize(600, 500);
		setTitle("Pen 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);

		oldPoint = new Point();
		newPoint = new Point();
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON3) {
				oldPoint = newPoint;
				redPen = !redPen;
			}
			else {
				newPoint = oldPoint;
				newPoint = e.getPoint();
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		if (redPen)
            g.setColor(Color.RED);
        else
            g.setColor(Color.BLACK);

		g.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
	}
}