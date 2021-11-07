import ivisibile.IVisibile;
import figures.Figure;
import java.awt.*;

public class Button implements IVisibile {
    static int SPC = 20;
    static int DIM = 40;
    static int PAD = 4;

    private  int x,y, w,h;
    protected  int    idx;
    private Figure fig;

    public Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        this.fig.x = PAD+SPC;
        this.fig.y = PAD+(SPC*2) + idx*DIM;
        this.fig.w = DIM-PAD*2;
        this.fig.h = DIM-PAD*2;
    }

    public boolean clicked (int x, int y) {
        return (SPC<=x && x<=SPC+DIM && (SPC*2)+this.idx*DIM<=y && y<=(SPC*2)+this.idx*DIM+DIM);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        

        g2d.setColor(Color.LIGHT_GRAY);

        if (focused==true) {
             g2d.setColor(Color.GREEN);
        }

        g2d.fillRect(SPC, (SPC*2)+this.idx*DIM, DIM, DIM);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(SPC, (SPC*2)+this.idx*DIM, DIM, DIM);

        this.fig.paint(g, false);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(SPC, (SPC*2)+5*DIM, DIM, DIM);

    }
}
