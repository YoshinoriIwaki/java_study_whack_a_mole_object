package whack_a_mole2;
import java.applet.*;
import java.awt.*;
import java.lang.Math;

public class Mogura2 {
	MoguraApp2 owner;
	Image myImage;
	int left, top;
	int maxLeft, maxTop;
	
	public void init(MoguraApp2 anApplet, int maxX, int maxY) {
		owner = anApplet;
		myImage = owner.getImage(owner.getDocumentBase(), "Mogura.gif");
		left = 0;
		top = 0;
		maxLeft = maxX;
		maxTop = maxY;
	}
	
	public void paint(Graphics g) {
		g.drawImage(myImage, left, top, owner);
	}
	
	public void timerAction() {
		left = (int)((double)maxLeft * Math.random());
		top	 = (int)((double)maxTop * Math.random());
	}
	
	public boolean inside(int x, int y) {
		if (x < left) return false;
		if (x < top) return false;
		if (x > (left + myImage.getWidth(owner))) return false;
		if (y > (top + myImage.getHeight(owner))) return false;
		return true;
	}
	
	public boolean mouseDown(Event evt, int x, int y) {
		owner.addScore(10);
		return true;
	}
}
