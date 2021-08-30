package figures;

import java.awt.*;

public class Losango {
    public int x1,x2,x3,x4, y1,y2,y3,y4;
    int w, h;
    int r, g, b, r1, g1, b1;

    public Losango (int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4, int r, int g, int b, int r1, int g1, int b1){
	this.x1 = x1;
	this.x2 = x2;
	this.x3 = x3;
	this.x4 = x4;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
	this.y4 = y4;
	this.w = this.y3 - this.y1;
	this.h = this.y2 - this.y4;
        this.r = r;
        this.g = g;
        this.b = b;
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
    }
    
    public void print () {
        System.out.format("Losango de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x1, this.y1);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(this.r, this.g, this.b));
	g2d.fillPolygon(new int[] {this.x1, this.x2, this.x3, this.x4}, new int[] {this.y1, this.y2, this.y3, this.y4}, 4);
	g.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawPolygon(new int[] {this.x1, this.x2, this.x3, this.x4}, new int[] {this.y1, this.y2, this.y3, this.y4}, 4);
    }

}