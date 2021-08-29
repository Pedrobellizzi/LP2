import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintRectApp5 {
    public static void main (String[] args) {
        PaintRectFrame frame = new PaintRectFrame();
        frame.setVisible(true);
    }
}

class PaintRectFrame extends JFrame {
    Rect r1;
    int x, y;
    int w, h;

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
        this.r1 = new Rect(100,150, 100,150);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(255,255,0));
	g2d.fillRect(100,150, 100,150);
	g.setColor(new Color(0,0,255));
        g2d.drawRect(100,150, 100,150);
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

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }


    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}