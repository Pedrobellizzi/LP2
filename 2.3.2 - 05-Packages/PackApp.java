import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Triangle t1;
    Losango l1;    

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(400, 400);
        this.setVisible(true);
	getContentPane().setBackground(Color.white);
        this.r1 = new Rect(50,50, 100,30);
        this.e1 = new Ellipse(50,150, 150,50);
        this.t1 = new Triangle(100,150,125,250,300,350);
        this.l1 = new Losango(240,310,380,310,180,90,180,270);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.t1.paint(g);
        this.l1.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(255,255,0));
	g2d.fillRect(50,50, 100,30);
	g.setColor(new Color(0,0,255));
        g2d.drawRect(50,50, 100,30);
        
        g.setColor(new Color(173,255,47));
	g2d.fill(new Ellipse2D.Double(50,150, 150,50));
	g.setColor(new Color(0,71,171));
        g2d.draw(new Ellipse2D.Double(50,150, 150,50));
        
        g.setColor(new Color(240,230,140));
	g2d.fillPolygon(new int[] {100, 150, 125}, new int[] {250, 300, 350}, 3);
	g.setColor(new Color(128,0,0));
        g2d.drawPolygon(new int[] {100, 150, 125}, new int[] {250, 300, 350}, 3);

        g.setColor(new Color(237,145,33));
	g2d.fillPolygon(new int[] {240,310,380,310}, new int[] {180,90,180,270}, 4);
	g.setColor(new Color(220,20,60));
	g2d.drawPolygon(new int[] {240,310,380,310}, new int[] {180,90,180,270}, 4);
    }
}





