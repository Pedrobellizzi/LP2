package figures;

import java.awt.*;

public class Line extends Figure{
    
    public Line (int x, int y, int w, int h, Color fundo, Color contorno) {
        super(x,y, w,h, fundo, contorno);        
               
    }

    public void print () {
        System.out.format("Reta de tamanho (%d) com inicio na posicao (%d,%d).\n",
            this.w, this.x, this.y);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(this.contorno);
        g2d.drawLine(this.x,this.y, this.x + w, this.y + (h/2));

        if (focused) {
            g2d.setPaint(Color.RED);
            g2d.drawRect(this.x,this.y, this.w, this.h/2);
            
        }

    }
}