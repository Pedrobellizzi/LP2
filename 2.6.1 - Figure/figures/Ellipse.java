package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;


public class Ellipse extends Figure {
    int x, y;
    int w, h;
    int r, g, b, r1, g1, b1;

    public Ellipse (int x, int y, int w, int h, int r, int g, int b, int r1, int g1, int b1) {
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

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(this.r, this.g, this.b));        
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}



