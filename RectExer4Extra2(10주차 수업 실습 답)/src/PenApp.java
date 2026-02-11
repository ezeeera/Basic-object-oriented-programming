//==========================================================
//	Simple Line Application in Java
//	두번의 클릭으로 선을 정의, 첫번째 클릭점은 선의 시작점이고 두번째 클릭점은 선의 끝점
//선 자체를 객체로 보기. 선 클래스를 정의해서 그리기
//선 두 개를 그리는데 두 번째 선 객체가 그려지자마자 길이 비교하고 선 색 변화
//기본 색은 블루, 길면 레드로 바뀌기
//==========================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public Line theLine1 = null; 
	public Line theLine2 = null;
	public int startX, startY;
	public int endX, endY;
	public boolean firstClick = true;
	public boolean line1 = true;
	
	
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

			if(firstClick) {
				startX = x;
		        startY = y;
		        firstClick = false;
			}else {
				endX = x;
				endY = y;
				if(line1) {
					theLine1 = new Line(startX, startY, endX, endY);
					line1 = false;
				} else {
					theLine2 = new Line(startX, startY, endX, endY);
					if (theLine1.length() > theLine2.length()) {
						theLine1.col = Color.red;
					} else {
						theLine2.col = Color.red;
					}
					line1 = true;
				}
				firstClick = true;
			}
			repaint();
			}
		}
	
	public void paint(Graphics g) {	
		if (theLine1 != null) {
			theLine1.draw(g);
		}
		if (theLine2 != null) {
			theLine2.draw(g);
			theLine1 = null;
			theLine2 = null;
		}
	}
}