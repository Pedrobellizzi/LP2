package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;


public class Ellipse extends Figure {

    public Ellipse (int x, int y, int w, int h, Color fundo, Color contorno) {
        super(x,y, w,h, fundo, contorno);        

    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        if (focused) {
            g2d.setPaint(Color.RED);
            g2d.fillOval(this.x-2,this.y-2, this.w+4,this.h+4);
        }

        g.setColor(this.fundo);        
        g2d.fillOval(this.x,this.y, this.w,this.h);
        g.setColor(this.contorno);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}



