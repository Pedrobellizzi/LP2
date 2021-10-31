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
    int dx,dy;
    int corcontorno = 0;
    int cordefundo = 0;
    Color cores[] = {Color.BLUE, Color.BLACK, Color.CYAN, Color.RED, Color.GREEN, Color.YELLOW, Color.WHITE, Color.GRAY, Color.PINK, Color.ORANGE, Color.MAGENTA};


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
                    int x = evt.getX();
                    int y = evt.getY();
                    focus = null;
                    for (Figure fig: figs){ 
                        if (fig.clicked(x,y)){
                            focus = fig;
                            dx = (focus.x - x);
                            dy = (focus.y - y);  
                        }
                     }
		     if (focus!=null){
			figs.remove(focus);	
                        figs.add(focus);
                        focus.contorno = Color.red;  		    
		     }
                     repaint();
                 }
            }
        );
        
       this.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent move) {
                    pMouse = getMousePosition();
                    if (focus != null) {
                        focus.x = pMouse.x + dx;
                        focus.y = pMouse.y + dy;
                    }
                    repaint();
                }
            }
        );


        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    pMouse = getMousePosition();
                    int x = pMouse.x;
		    int y = pMouse.y;
                    int w = 80;
                    int h = 60;
                                    
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, w,h, Color.yellow, Color.black));
                    }
                    
                    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h, Color.yellow, Color.black));
                    }
                     
                     if (evt.getKeyChar() == 't') {
                        figs.add(new Triangle(x,y, w,h, Color.yellow, Color.black));
                     }

                     if (evt.getKeyChar() == 'p') {
                        figs.add(new Pentagono(x,y, w,h, Color.yellow, Color.black));
                     } 

                     if (evt.getKeyChar() == 'l') {
                        figs.add(new Line(x,y, w,h, Color.white, Color.black));                   
                     } 


                     if(evt.getKeyCode() == 127){
			figs.remove(focus);
                     }
   
                  
                     if(evt.getKeyChar() == 'd'){
			focus.x += 5;
                     }
                                          
                     if(evt.getKeyChar() == 's'){
			focus.x -= 5;
                     }
                     
                     if(evt.getKeyChar() == 'c'){
			focus.y -= 5;
                     }

                     if(evt.getKeyChar() == 'b'){
			focus.y += 5;
                     }
     

                     if (evt.getKeyChar()=='a'){
                        focus.w+=10;
			focus.h+=10;
                     }

                     if (evt.getKeyChar()=='m'){
			 if (focus.w<=10 || focus.h<=10){
                        	focus.w-=0;
				focus.h-=0;
			 }
			 else{
				focus.w-=5;
				focus.h-=5;
			 } 
                     }
	
	      
		     if (evt.getKeyCode() == 32){
                         for( Figure fig: figs){
                             if ((focus == null) || (focus!=null)){
                                 focus=fig;
                                 figs.remove(focus);
                                 figs.add(focus);
                                 focus.contorno = Color.red;
                                 break;
                             }
                             

                         }                  
                     }


		     if(evt.getKeyChar() == 'v'){
                         if (corcontorno == 10){
                             corcontorno = 0;
                         }
                         else {
                             corcontorno++;
                         }
                         focus.contorno = cores[corcontorno];
                       }
  		     
                      if (evt.getKeyChar() == 'f'){
                          if (cordefundo == 10){
                              cordefundo = 0;
                          }
                          else {
                              cordefundo++;
                          }
                          focus.fundo = cores[cordefundo];
                      }
                      repaint();
                 }
             }
        );

        

        this.setTitle("Projeto de Figuras 1");
        this.setSize(450, 450);
        this.setVisible(true);
	getContentPane().setBackground(Color.white);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {            
            if(fig!=focus){
		fig.contorno = Color.black;
            }

            fig.paint(g);
        }
    }
}