package xyz.kajih.wobj;
import lombok.Data;

import java.awt.*;

@Data
public class Solid {

    private int x;
    private int y;
    private Polygon poly;

    public boolean collide(Solid checkObj) {
        return false;
    }

    public Rectangle getBounds() {
        return this.poly.getBounds();
    }

    public void drawRelative(Graphics2D g) {
        Polygon tmp = new Polygon(this.poly.xpoints, this.poly.ypoints, this.poly.npoints);
        tmp.translate(this.x, this.y);
        g.drawPolygon(tmp);
    }
    public Solid() {}
}
