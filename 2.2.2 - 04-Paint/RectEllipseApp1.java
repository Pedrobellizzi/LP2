import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp1 {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    
    Ellipse e1;    

    public RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Retangulo + Ellipse");
        this.setSize(400, 400);
        this.setVisible(true);
	getContentPane().setBackground(Color.white);
        this.e1 = new Ellipse(100,100, 150,50);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        Graphics2D gd = (Graphics2D) g;
        g.setColor(new Color(255,255,0));
	gd.fill(new Ellipse2D.Double(100,100, 150,50));
	g.setColor(new Color(0,0,255));
        gd.draw(new Ellipse2D.Double(100,100, 150,50));
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

class Ellipse {
    int x, y;
    int w, h;

    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D gd = (Graphics2D) g;
        gd.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        gd.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}



