package figures;

import ivisibile.IVisibile;

import java.awt.Graphics;
import java.awt.*;

public abstract class Figure implements IVisibile {

    public int x, y;
    public int w, h;
    public Color fundo;
    public Color contorno;
   
    
    public Figure (int x, int y, int w, int h, Color fundo, Color contorno) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;
    }

    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    } 

    public boolean clicked (int x, int y) {
          return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }

    
   
}