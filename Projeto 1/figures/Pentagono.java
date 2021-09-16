package figures;

import java.awt.*;

public class Pentagono extends Figure {
    
    public Pentagono (int x, int x2, int x3, int x4, int x5, int y, int y2, int y3, int y4, int y5, int w, int h, int r, int g, int b, int r1, int g1, int b1){
        super(x,y, w,h, r,g,b, r1,g1,b1);	
        this.x2 = x+20;
	this.x3 = x+40;
	this.x4 = x+30;
        this.x5 = x+10;
        this.y2 = y-15;
        this.y3 = y;
	this.y4 = y+20;
        this.y5 = y+20;
	this.w = this.x3 - this.x;
	this.h = this.y5 - this.y2;
        
    }
    
    public void print () {
        System.out.format("Pentagono de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(this.r, this.g, this.b));
	g2d.fillPolygon(new int[] {this.x, this.x2, this.x3, this.x4, this.x5}, new int[] {this.y, this.y2, this.y3, this.y4, this.y5}, 5);
	g.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawPolygon(new int[] {this.x, this.x2, this.x3, this.x4, this.x5}, new int[] {this.y, this.y2, this.y3, this.y4, this.y5}, 5);
    }

}
