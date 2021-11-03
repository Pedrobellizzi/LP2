
package ivisibile;

import java.awt.Graphics;

public interface IVisibile {
    public boolean clicked (int x, int y);
    public void    paint   (Graphics g, boolean focused);
}