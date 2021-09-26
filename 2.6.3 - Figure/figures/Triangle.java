package figures;

import java.awt.*;

public class Triangle extends Figure {
    public int x2,x3, y2,y3;

    public Triangle(int x, int x2, int x3, int y, int y2, int y3, int w, int h, int r, int g, int b, int r1, int g1, int b1){
        super(x,y, w,h, r,g,b, r1,g1,b1);
	this.x2 = x+40;
	this.x3 = x-40;
        this.y2 = y+40;
        this.y3 = y+40;
        this.w = this.x3 - this.x;
	this.h = y2-((this.y3 + this.y)/2);
        
    }
    public void print () {
        System.out.format("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g.setColor(new Color(this.r, this.g, this.b)); 
        g2d.fillPolygon(new int[] {this.x, this.x2, this.x3}, new int[] {this.y, this.y2, this.y3}, 3);
	g.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawPolygon(new int[] {this.x, this.x2, this.x3}, new int[] {this.y, this.y2, this.y3}, 3);
    }

}
