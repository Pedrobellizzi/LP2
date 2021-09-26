package figures;

import java.awt.*;

public class Line extends Figure{
    public int x2,y2;
	
    public Line (int x, int y, int x2, int y2, int w, int h, int r, int g, int b, int r1, int g1, int b1) {
        super(x,y, w,h, r,g,b, r1,g1,b1);        
        this.x2 = x2;
        this.y2 = y2;
        this.w = this.x2 - this.x;
	this.h = this.y2 - this.y;
    }

    public void print () {
        System.out.format("Reta de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g.setColor(new Color(this.r, this.g, this.b));        
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawLine(this.x,this.y, this.x2,this.y2);
    }
}
