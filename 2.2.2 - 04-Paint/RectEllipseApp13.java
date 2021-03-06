import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp13 {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;    

    public RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Retangulo + Ellipse");
        this.setSize(450, 450);
        this.setVisible(true);
	getContentPane().setBackground(Color.white);
        this.e1 = new Ellipse(100,100, 150,50, 173,255,47, 25,25,22);
        this.e2 = new Ellipse(150,200, 100,40, 255,191,0, 72,61,139);
        this.e3 = new Ellipse(200,300, 180,60, 255,255,0, 0,0,255);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
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


class Ellipse {
    int x, y;
    int w, h;
    int r, g, b, r1, g1, b1;

    Ellipse (int x, int y, int w, int h, int r, int g, int b, int r1, int g1, int b1) {
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
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(this.r, this.g, this.b));        
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}



