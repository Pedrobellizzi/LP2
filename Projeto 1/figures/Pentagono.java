package figures;

import java.awt.*;

public class Pentagono extends Figure {
    public int x1,y1; 

    public Pentagono (int x, int y, int w, int h, int r, int g, int b, int r1, int g1, int b1){
        super(x,y, w,h, r,g,b, r1,g1,b1);	
                
    }
    
    public void print () {
        System.out.format("Pentagono de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x1[] = {this.x, this.x+30, this.x+60, this.x+45, this.x+15};
        int y1[] = {this.y, this.y-15, this.y, this.y+35, this.y+35};
        g.setColor(new Color(this.r, this.g, this.b));
	g2d.fillPolygon(x1, y1, 5);
	g.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.drawPolygon(x1, y1, 5);
    }

}