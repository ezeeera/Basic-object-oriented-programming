//==========================================================
//	Simple Line Application in Java
//	두번의 클릭으로 선을 정의, 첫번째 클릭점은 선의 시작점이고 두번째 클릭점은 선의 끝점
//선 자체를 객체로 보기. 선 클래스를 정의해서 그리기
//==========================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public Line theLine = null; //아직은 선개체가 만들어지지 않음
	public int startX, startY;
	public int endX, endY;
	public boolean firstClick = true; //두번의클릭이니까

	public static void main(String[ ] args) {
		PenApp window = new PenApp(); //객체가 생성 됨. 윈도우객체임. 펜앱클래스에서 객체 생성하니까 생성자메소드에서 생성된 애를 꾸미는 초기 작업하면 윈도우 객체 완성
		window.setVisible(true);//윈도우객체가 화면에 드러남. paint가 호출된다.---아직 선 ㅇ객체 없음. 따라서 paint에서 null체크
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
					theLine = null;
					theLine = new Line(startX, startY, endX, endY);//먼저 있던 애는 가비지 콜렉터에 의해 제거된다.
					firstClick = true;
				}
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				if (theLine != null) {
					theLine.moveTo(x, y);
					theLine.col = Color.red;
				}
			}
			repaint(); 
		}
	}

	public void paint(Graphics g) {
		if(theLine != null) {//프로그램 초기 호출 되는것감안
			theLine.draw(g);
			System.out.println("length of line: " + theLine.length());
		}
	}
}