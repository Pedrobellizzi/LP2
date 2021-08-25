
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 15,25);
        r1.area();
	r1.print();
	r1.drag(5,3);
	r1.print();
        r1.drag(12,9);
	r1.print();
     }
} 

class Rect {
     int x, y;
     int w, h;
     int area;
     int dx, dy;
     Rect (int x, int y, int w, int h) {
         this.x = x;
         this.y = y;
         this.w = w;
         this.h = h;
     }

     int area () {
	 area = w*h;
         return area;
     }

     void drag(int dx, int dy){
        this.x = this.x + dx;
        this.y = this.y + dy;
    }


     void print () {  
       System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e com area de (%d).\n", 
           this.w, this.h, this.x, this.y, this.area);
       }
}



