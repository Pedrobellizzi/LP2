package figures;

import java.awt.*;

public class Triangle extends Figure {
    
    public Triangle(int x, int y, int w, int h, int r, int g, int b, int r1, int g1, int b1){
        super(x,y, w,h, r,g,b, r1,g1,b1);
     
    }

    public void print () {
        System.out.format("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x1[] = {this.x, ((this.w) / 2) + (this.x), (this.w) + (this.x)};
        int y1[] = {this.y + h, this.y, this.y + h};
	g.setColor(new Color(this.r, this.g, this.b)); 
        g2d.fillPolygon(x1, y1, 3);
	g.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawPolygon(x1, y1, 3);
    }

}