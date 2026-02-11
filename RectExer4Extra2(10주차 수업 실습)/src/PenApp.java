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
	public Line firstLine = null; 
	public Line secondLine = null;
	public int firstX, firstY, secondX, secondY;
	public int thirdX, thirdY, fourthX, fourthY;
	public int clickCount = 0;; 
	
	
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

			switch(clickCount) {
			case 0: firstX = x; firstY = y; clickCount++; break;
			case 1: secondX = x; secondY = y; clickCount++;
					firstLine = new Line(firstX, firstY, secondX, secondY);
					repaint();
					break;
			case 2: thirdX = x; thirdY = y; clickCount++; break;
			case 3: fourthX = x; fourthY = y; clickCount = 0;
					secondLine = new Line(thirdX, thirdY, fourthX, fourthY);
					repaint();
				}
			}
		}
	
	public void paint(Graphics g) {	
		if(firstLine != null)
		      firstLine.draw(g);
		if(secondLine != null)
			  secondLine.draw(g);

		if(firstLine != null && secondLine != null) {
			if(firstLine.length() > secondLine.length()) {
				firstLine.col = Color.red;
			}
			else {
				secondLine.col = Color.red;
			}
			firstLine.draw(g);
			secondLine.draw(g);
			firstLine = null;
			secondLine = null;
		}
	}
}