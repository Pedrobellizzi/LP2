
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'r') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        int r = 255;
                        int g = 255;
                        int b = 0;
                        int r1 = 0;
                        int g1 = 0;
                        int b1 = 255;
                        figs.add(new Rect(x,y, w,h, r,g,b, r1,g1,b1));
                        
                    } else if (evt.getKeyChar() == 'e') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        int r = 173;
                        int g = 255;
                        int b = 47;
                        int r1 = 0;
                        int g1 = 71;
                        int b1 = 171;
                        figs.add(new Ellipse(x,y, w,h, r,g,b, r1,g1,b1));
                        
                    } else if (evt.getKeyChar() == 't') {
                        int x1 = rand.nextInt(350);
                        int x2 = rand.nextInt(350);
                        int x3 = rand.nextInt(350);
                        int y1 = rand.nextInt(350);
                        int y2 = rand.nextInt(350);                       
                        int y3 = rand.nextInt(350);
                        int r = 240;
                        int g = 230;
                        int b = 140;
                        int r1 = 128;
                        int g1 = 0;
                        int b1 = 0;
                        figs.add(new Triangle(x1,x2,x3, y1,y2,y3, r,g,b, r1,g1,b1));
                        
                     } else if (evt.getKeyChar() == 'p') {
                        int x1 = rand.nextInt(350);
                        int x2 = rand.nextInt(350);
                        int x3 = rand.nextInt(350);
                        int x4 = rand.nextInt(350);
                        int x5 = rand.nextInt(350);
                        int y1 = rand.nextInt(350);
                        int y2 = rand.nextInt(350);                       
                        int y3 = rand.nextInt(350);
                        int y4 = rand.nextInt(350);
                        int y5 = rand.nextInt(350);
                        int r = 237;
                        int g = 145;
                        int b = 33;
                        int r1 = 220;
                        int g1 = 20;
                        int b1 = 60;
                        figs.add(new Pentagono(x1,x2,x3,x4,x5, y1,y2,y3,y4,y5, r,g,b, r1,g1,b1));
                           
                      }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(450, 450);
        this.setVisible(true);
	getContentPane().setBackground(Color.white);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}