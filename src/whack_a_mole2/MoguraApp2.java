package whack_a_mole2;
import java.applet.*;
import java.awt.*;

public class MoguraApp2 extends Applet implements Runnable {
	Thread m_MoguraApplet = null;
	int moveInterval = 500;
	int totalTime = 30000;
	int elapseTime = 0;
	boolean isRunning = false;
	
	Mogura2 mog;
	int score = 0;
	
	public void init() {
		setBackground(Color.white);
		mog = new Mogura2();
		mog.init(this, 220, 140);
		resize(320, 240);
	}
	
	public void start() {
		if (m_MoguraApplet == null) {
			m_MoguraApplet = new Thread(this);
			m_MoguraApplet.start();
		}
	}
	
	public void run() {
		isRunning = true;
		while (elapseTime < totalTime) {
			try {
				timerAction();
				Thread.sleep(moveInterval);
				elapseTime = elapseTime + moveInterval;
			} catch (InterruptedException e){
				stop();
			}
		}
		isRunning = false;
		repaint();
	}
	
	public void stop() {
		if(m_MoguraApplet != null) {
			m_MoguraApplet.stop();
			m_MoguraApplet = null;
		}
	}
	
	public void timerAction() {
		mog.timerAction();
		repaint();
	}
	
	public void paint(Graphics g) {
		mog.paint(g);
		if(isRunning) {
			g.drawString("“¾“_=" + score, 10, 20);
		} else {
			g.drawString("“¾“_=" + score + "<I—¹>", 10, 20);
		}
	}
	
	public boolean mouseDown(Event evt, int x, int y) {
		if(mog.inside(x, y)) {
			mog.mouseDown(evt, x, y);
		}
		return true;
	}
	
	public void addScore(int addition) {
		score = score + addition;
	}
}
