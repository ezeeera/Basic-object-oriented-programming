import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class HelloWinApp extends Frame {
	String str;

	
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
		System.out.print("last name: ");
		str = s.next();
		if (str.equalsIgnoreCase("Kim"))
			str = "Welcome" + " " + str + "!" + "(" + str.length() + ")";
		else
			str = "Who are you?" ;
		s.close();
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) { 
			repaint();
		}
	}

	public void paint(Graphics g) {
		g.drawString(str, 200, 200);
	}
}