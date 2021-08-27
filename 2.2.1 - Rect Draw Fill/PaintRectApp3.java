import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintRectApp3 {
    public static void main (String[] args) {
        PaintRectFrame frame = new PaintRectFrame();
        frame.setVisible(true);
    }
}

class PaintRectFrame extends JFrame {
    Rect r1;
    
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
        this.r1 = new Rect(70,120, 50,150);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
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
	g.setColor(new Color(255,191,0));
	g2d.fillRect(this.x,this.y, this.w,this.h);
	g.setColor(new Color(72,61,139));
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}