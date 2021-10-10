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
    Color paleta[] = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.WHITE, Color.BLACK, Color.GRAY, Color.PINK, Color.ORANGE, Color.MAGENTA};


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
                            dx = (focus.x - pMouse.x);
                            dy = (focus.y - pMouse.y);  
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
        
       this.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent move) {
                    pMouse = getMousePosition();
                    if (focus != null) {
                        figs.remove(focus);
                        figs.add(focus);
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
                        figs.add(new Rect(x,y, w,h, Color.blue, Color.black));
                    }
                    
                    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h, Color.yellow, Color.black));
                    
                    }
                     
                     if (evt.getKeyChar() == 't') {
                        figs.add(new Triangle(x,y, w,h, Color.green, Color.white));
                        
                     }

                     if (evt.getKeyChar() == 'p') {
                        figs.add(new Pentagono(x,y, w,h, Color.red, Color.black));
                           
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

                        
                     repaint();

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
                                break;
                            }
                            repaint();
                            

                        }
                        
                    }
		    if(evt.getKeyChar() == 'v'){
                       if (corcontorno == 9){
                           corcontorno = 0;
                       }
                       else {
                           corcontorno++;
                       }
                       focus.contorno = paleta[corcontorno];

                   }
		   repaint();

                   if (evt.getKeyChar() == 'f'){
                       if (cordefundo == 9){
                           cordefundo = 0;
                       }
                       else {
                           cordefundo++;
                       }
                       focus.fundo = paleta[cordefundo];

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
            fig.paint(g);
        }
    }
}