import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintRectApp12 {
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
        this.r1 = new Rect(100,100, 100,50, 0,255,255, 0,0,205);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        
    }
}

class Rect {
    int x, y;
    int w, h;
    int r, g, b, r1, g1, b1;

    Rect (int x, int y, int w, int h, int r, int g, int b, int r1, int g1, int b1) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }


    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(this.r, this.g, this.b));
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}