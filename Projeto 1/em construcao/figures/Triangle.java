package figures;

import java.awt.*;

public class Triangle extends Figure {
    
    public int x1,y1,x2,y2;

    public Triangle(int x, int y, int w, int h, Color fundo, Color contorno){
        super(x,y, w,h, fundo, contorno);
     
    }

    public void print () {
        System.out.format("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x1[] = {this.x, ((this.w) / 2) + (this.x), (this.w) + (this.x)};
        int y1[] = {this.y + h, this.y, this.y + h};

        if (focused) {
            int x2[] = {this.x-2, ((this.w+4) / 2) + (this.x-2), (this.w+4) + (this.x-2)};
            int y2[] = {this.y + h + 2, this.y-2, this.y + h + 2};
            g2d.setPaint(Color.RED);
            g2d.fillPolygon(x2, y2, 3);
        }

	g.setColor(this.fundo); 
        g2d.fillPolygon(x1, y1, 3);
	g.setColor(this.contorno);
        g2d.drawPolygon(x1, y1, 3);
    }

}