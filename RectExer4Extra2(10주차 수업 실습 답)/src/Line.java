// Line class

import java.awt.Color;
import java.awt.Graphics;

public class Line {
    // 필드
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public Color col;
    
    // 생성자
    Line(int sx, int sy, int ex, int ey) {
    	startX = sx;
    	startY = sy;
    	endX = ex;
    	endY = ey;
    	col = Color.blue; //초기화시키는 코드
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
    

    void draw(Graphics g) {
    	g.setColor(col);
    	g.drawLine(startX, startY, endX, endY);
    }
    
    int length() {
        int distance = (int)Math.sqrt(Math.pow((double)(endX-startX), 2.0) + Math.pow((double)(endY-startY), 2.0));
        return distance;
    }
}