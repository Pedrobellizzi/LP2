import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
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
    Figure focus = null;
    Point pMouse = null;
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent evt){
                    pMouse = getMousePosition();
                    focus = null;
                    for (Figure fig: figs){ 
                        if (fig.clicked(pMouse.x,pMouse.y)){
                            focus = fig;
                        }
			if (focus!=null){
			    figs.add(focus);
			    figs.remove(focus);			    
			}
			repaint();
                    }
                }
            }
        );
        

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    pMouse = getMousePosition();
                    int x = pMouse.x;
		    int y = pMouse.y;
                    int w = 60;
                    int h = 60;
                                      
                    if (evt.getKeyChar() == 'r') {
                        int r = 255;
                        int g = 255;
                        int b = 0;
                        int r1 = 0;
                        int g1 = 0;
                        int b1 = 255;
                        figs.add(new Rect(x,y, w,h, r,g,b, r1,g1,b1));
                        
                    } else if (evt.getKeyChar() == 'e') {
                        int r = 173;
                        int g = 255;
                        int b = 47;
                        int r1 = 0;
                        int g1 = 71;
                        int b1 = 171;
                        figs.add(new Ellipse(x,y, w,h, r,g,b, r1,g1,b1));
                     
                     } else if (evt.getKeyChar() == 't') {
                        int r = 240;
                        int g = 230;
                        int b = 140;
                        int r1 = 128;
                        int g1 = 0;
                        int b1 = 0;
                        figs.add(new Triangle(x,y, w,h, r,g,b, r1,g1,b1));
                        
                     } else if (evt.getKeyChar() == 'p') {
                        int r = 237;
                        int g = 145;
                        int b = 33;
                        int r1 = 220;
                        int g1 = 20;
                        int b1 = 60;
                        figs.add(new Pentagono(x,y, w,h, r,g,b, r1,g1,b1));
                           
                     } else if (evt.getKeyChar() == 'l') {
                        int r = 248;
                        int g = 248;
                        int b = 255;
                        int r1 = 153;
                        int g1 = 51;
                        int b1 = 153;
                        figs.add(new Line(x,y, w,h, r,g,b, r1,g1,b1));  
                      
                     } else if(evt.getKeyCode() == 127){
			figs.remove(focus);
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