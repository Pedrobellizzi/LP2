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
    ArrayList<Rect> rs = new ArrayList<Rect>();
    ArrayList<Ellipse> es = new ArrayList<Ellipse>();
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
                        rs.add(new Rect(x,y, w,h, r,g,b, r1,g1,b1));
                        repaint();  // outer.repaint()
                    }
                    if (evt.getKeyChar() == 'e') {
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
                        es.add(new Ellipse(x,y, w,h, r,g,b, r1,g1,b1));
                        repaint(); 
                    }
                }
            }
        );        


        this.setTitle("Lista de Retangulos e Ellipses");
        this.setSize(450, 450);
        this.setVisible(true);
	getContentPane().setBackground(Color.white);
                
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Rect r: this.rs) {
            r.paint(g);
    }
        for (Ellipse e: this.es) {
            e.paint(g);
        
    }
    }
}





