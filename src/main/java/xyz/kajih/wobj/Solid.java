package xyz.kajih.wobj;
import java.awt.*;

public class Solid {

    private int x;
    private int y;
    private Polygon poly;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Polygon getPoly() {
        return poly;
    }

    public void setPoly(Polygon poly) {
        this.poly = poly;
    }

    public boolean collide(Solid checkObj) {
        return false;
    }

    public Rectangle getBounds() {
        return this.poly.getBounds();
    }

    public void drawRelative(Graphics g) {
        Polygon tmp = new Polygon(this.poly.xpoints, this.poly.ypoints, this.poly.npoints);
        tmp.translate(this.x, this.y);
        g.drawPolygon(tmp);
    }

    public Solid() {}

}
