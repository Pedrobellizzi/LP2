package figures;

import java.awt.Graphics;
import java.awt.*;

public abstract class Figure {

    public int x, y;
    public int w, h;
    public int r, g, b, r1, g1, b1;
    
    public Figure (int x, int y, int w, int h, int r, int g, int b, int r1, int g1, int b1) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
    }

    public boolean clicked (int coordX, int coordY) {
          return (((x <= coordX) && (y <= coordY)) && ((coordX <= (x + w)) && (coordY <= (y + h))));
    }

    public abstract void paint (Graphics g);

}