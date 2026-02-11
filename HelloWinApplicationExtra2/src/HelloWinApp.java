import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class HelloWinApp extends Frame {
	String name;
	String id;
	String sname;
	String info;
	

	public static void main(String[ ] args) {
		HelloWinApp window = new HelloWinApp();
		window.setVisible(true);
	}
	
	public HelloWinApp() {
		setSize(600, 500);
		setTitle("Hello Window Application");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
		
		Scanner s = new Scanner(System.in); 
		System.out.print("학번: ");
		id = s.next();
		System.out.print("이름: ");
		name = s.next();
		sname = name.substring(0,1).concat("**");
		s.close();
		
		info = id + " " + sname;
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) { 
			repaint();
		}
	}

	public void paint(Graphics g) {
		g.drawString(info, 100, 100);
	}
}