package figures;

import java.awt.*;

public class Triangle extends Figure {
    
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
	g.setColor(this.fundo); 
        g2d.fillPolygon(x1, y1, 3);
	g.setColor(this.contorno);
        g2d.drawPolygon(x1, y1, 3);
    }

}