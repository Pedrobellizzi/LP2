import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintRectApp2 {
    public static void main (String[] args) {
        PaintRectFrame frame = new PaintRectFrame();
        frame.setVisible(true);
    }
}

class PaintRectFrame extends JFrame {
    Rect r1;
    Rect r2;
    Rect r3;

    public PaintRectFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Paint Retangulo");
        this.setSize(400, 400);
        this.setVisible(true);
	getContentPane().setBackground(Color.white);
        this.r1 = new Rect(50,50, 150,50);
        this.r2 = new Rect(70,120, 50,150);
        this.r3 = new Rect(150,150, 100,120);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }


    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g.setColor(new Color(0,255,0));
	g2d.fillRect(50,50, 150,50);
	g.setColor(new Color(255,0,0));
        g2d.drawRect(50,50, 150,50);
	
        g.setColor(new Color(245,245,0));
	g2d.fillRect(70,120, 50,150);
	g.setColor(new Color(255,0,0));
        g2d.drawRect(70,120, 50,150);
        
        g.setColor(new Color(255,215,0));
	g2d.fillRect(150,150, 100,120);
        g.setColor(new Color(0,255,0));
        g2d.drawRect(150,150, 100,120);
		
    }
}