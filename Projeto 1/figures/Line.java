package figures;

import java.awt.*;

public class Line extends Figure{
    
    public Line (int x, int y, int w, int h, int r, int g, int b, int r1, int g1, int b1) {
        super(x,y, w,h, r,g,b, r1,g1,b1);        
               
    }

    public void print () {
        System.out.format("Reta de tamanho (%d) com inicio na posicao (%d,%d).\n",
            this.w, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawLine(this.x,this.y, this.x + w, this.y + h);
    }
}