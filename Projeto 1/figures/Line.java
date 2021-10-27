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

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(this.contorno);
        g2d.drawLine(this.x,this.y, this.x + w, this.y + (h/2));
    }
}