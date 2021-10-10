package figures;

import java.awt.*;

public class Pentagono extends Figure {
    public int x1,y1; 

    public Pentagono (int x, int y, int w, int h, Color fundo, Color contorno){
        super(x,y, w,h, fundo, contorno);	
                
    }
    
    public void print () {
        System.out.format("Pentagono de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x1[] = {this.x, this.x+(w/2), this.x+w, this.x+((w/4)*3), this.x+(w/4)};
        int y1[] = {this.y+(h/4), this.y, this.y+(h/4), this.y+h, this.y+h};
        g.setColor(this.fundo);
	g2d.fillPolygon(x1, y1, 5);
	g.setColor(this.contorno);
        g2d.drawPolygon(x1, y1, 5);
    }

}