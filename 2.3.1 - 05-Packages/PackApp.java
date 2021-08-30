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
        this.r1 = new Rect(50,50, 100,30, 255,255,0, 0,0,255);
        this.e1 = new Ellipse(50,150, 150,50, 173,255,47, 0,71,171);
        this.t1 = new Triangle(100,150,125,250,300,350, 240,230,140, 128,0,0);
        this.l1 = new Losango(240,310,380,310,180,90,180,270, 237,145,33, 220,20,60);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.t1.paint(g);
        this.l1.paint(g);

        
    }
}





