import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	final public int COUNT = 10;
	public Rect[] rects; // 이런 배열 만들거야 하고 선언만
	public int rectCount = 0;
	public int upperLeftX, upperLeftY, lowerRightX, lowerRightY;
	public boolean firstClick = true;
	public boolean firstRClick = true;
	public Rect movingRect = null;

	public static void main(String[] args) {
		RectApp window = new RectApp();
		window.setVisible(true);
	}

	public RectApp() {
		setSize(600, 00);
		setTitle("Rect 응용");
		addMouseListener(new MouseKeeper());
		rects = new Rect[COUNT]; // 배열은 여기에서 생성이 된다.-이거 없으면 런타임 오류
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

			if (e.getButton() == MouseEvent.BUTTON3) {
				if (rectCount > 0) {
					if (firstClick) {
						for (int i = rectCount; i > 0; i--) { // 역순으로 조사하기. 면이 포함되는게 나중에 나오는 사각형이여야하니까)
							if (rects[i - 1].includes(x, y)) {
								movingRect = rects[i - 1];
								movingRect.color = Color.red;
								firstClick = false;
								break;
							}
						}
					} else {
						if (movingRect != null) {
							movingRect.moveTo(x, y);
							movingRect.color = Color.blue;
							firstClick = true;// 다음 단계로 가기 위한
							movingRect = null;// 다음 단계로 가기 위한
						}
					}
					repaint();// 무조건 여기에 있어야 한다.
				}
			} else {
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
						for (int i = 0; i < rectCount; i++) {
							rects[i].rank = 1;
						}
						for (int i = 0; i < rectCount; i++) {
							for (int j = 0; j < rectCount; j++) {
								if (rects[i].area() < rects[j].area()) {
									rects[i].rank = rects[i].rank + 1;
								}
							}
						}
						firstClick = true;
						repaint();
					}
				}
			}
		}
	}

	public void paint(Graphics g) {
		for (int i = 0; i < rectCount; i++) {
			rects[i].draw(g);
			g.drawString(String.valueOf(rects[i].rank), rects[i].upperLeftX, rects[i].upperLeftY);
		}
	}
}
