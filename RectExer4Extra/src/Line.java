// Line class

import java.awt.Color;
import java.awt.Graphics;

public class Line {
    // 필드
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public Color color;
    
    // 생성자
    Line(int sx, int sy, int ex, int ey) {
    	startX = sx;
    	startY = sy;
    	endX = ex;
    	endY = ey;
    }

    // 메소드
    void moveTo(int sx, int sy) {
    	int deltaX = endX - startX;
    	int deltaY = endY - startY;
    	startX = sx;
    	startY = sy;
    	endX = sx + deltaX;
    	endY = sy + deltaY;
    }
    
    int length() {
        int dx = endX - startX;
        int dy = endY - startY;
        return (int)Math.sqrt(dx * dx + dy * dy);
        }

    void draw(Graphics g) {
    	g.setColor(color);
    	g.drawLine(startX, startY, endX, endY);
    }
}