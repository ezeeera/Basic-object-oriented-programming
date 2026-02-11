//=======================================================================
//	Simple Pen Application in Java
//	마우스의 두번 클릭으로 원이 생성됨
//	원은 5개까지 그려지며 이 원들은 윈도우의 크기 조정에도 유지됨
//=======================================================================

import java.awt.*;
import java.awt.event.*;

class Pt {
    int x;
    int y;
}

public class PenApp extends Frame {
    final public int MAX_CIRCLES = 5;
    public int circleCount = 0;
    public Pt[] startPoints;
    public Pt[] endPoints;
    public int[] areas;
    public int[] ranks;
    public boolean firstClick = true;

    public static void main(String[] args) {
        PenApp window = new PenApp();
        window.setVisible(true);
    }

    public PenApp() {
        setSize(600, 500);
        setTitle("Pen 응용");
        MouseKeeper mouse = new MouseKeeper();
        addMouseListener(mouse);

        startPoints = new Pt[MAX_CIRCLES];
        endPoints = new Pt[MAX_CIRCLES];
        areas = new int[MAX_CIRCLES];
        ranks = new int[MAX_CIRCLES];

        for (int i = 0; i < MAX_CIRCLES; i++) {
            startPoints[i] = new Pt();
            endPoints[i] = new Pt();
            areas[i] = 0;
            ranks[i] = 1;
        }
    }

    private class MouseKeeper extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (circleCount < MAX_CIRCLES) {
                if (firstClick) {
                    startPoints[circleCount].x = e.getX();
                    startPoints[circleCount].y = e.getY();
                    firstClick = false;
                } else {
                    endPoints[circleCount].x = e.getX();
                    endPoints[circleCount].y = e.getY();

                    int dx = endPoints[circleCount].x - startPoints[circleCount].x;
                    int dy = endPoints[circleCount].y - startPoints[circleCount].y;
                    int radius = (int) Math.sqrt(dx * dx + dy * dy);

                    areas[circleCount] = radius * radius;

                    for (int i = 0; i <= circleCount; i++) {
                        ranks[i] = 1; // 초기화
                        for (int j = 0; j <= circleCount; j++) {
                            if (areas[i] < areas[j]) {
                                ranks[i]++;
                            }
                        }
                    }

                    circleCount++;
                    firstClick = true;
                    repaint();
                }
            }
        }
    }

    public void paint(Graphics g) {
        for (int i = 0; i < circleCount; i++) {
            int dx = endPoints[i].x - startPoints[i].x;
            int dy = endPoints[i].y - startPoints[i].y;
            int radius = (int) Math.sqrt(dx * dx + dy * dy);

            g.drawOval(startPoints[i].x - radius, startPoints[i].y - radius,
                    2 * radius, 2 * radius);

            String rankStr = String.valueOf(ranks[i]);
            g.drawString(rankStr, startPoints[i].x, startPoints[i].y);
        }
    }
}