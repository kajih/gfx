package xyz.kajih.wobj;
import lombok.Data;

import java.awt.*;
import java.awt.geom.AffineTransform;

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

    public void drawRelative(Graphics2D g2d) {

        Polygon tmp = new Polygon(this.poly.xpoints, this.poly.ypoints, this.poly.npoints);
        tmp.translate(this.x, this.y);

        //g2d.rotate(Math.PI/16);

        g2d.drawPolygon(tmp);
        /*
        AffineTransform rotateTransform = new AffineTransform();
        AffineTransform saveXform = g2d.getTransform();
        rotateTransform.rotate(Math.PI/2,this.x,this.y);
        g2d.transform(rotateTransform);
        g2d.drawPolygon(tmp);
        g2d.transform(saveXform);
        */
    }
    public Solid() {}
}
