package xyz.kajih;
import xyz.kajih.wobj.Rocket;
import xyz.kajih.wobj.Solid;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Program extends JPanel {

    private int cx = 10;
    private int cy = 100;
    private int rad = 200;
    private float frameCount = 0;
    private float ticks = 0;

    Solid myOb;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.frameCount++;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        setBackground(Color.black);
        setForeground(Color.white);

        //g.drawLine(10, 10, 200, 300);
        /*
        g.drawOval(this.cx,this.cy, this.rad, this.rad);
        g.fillOval(this.cx+10,this.cy+10, this.rad-20, this.rad-20);
        g.drawRect(this.cx,this.cy, this.rad, this.rad);
        */
        myOb.setX(this.cx);
        myOb.setY(this.cy);
        myOb.drawRelative(g2d);

        g2d.drawString("Framerate:"+this.frameCount / this.ticks, 700, 700);
    }

    private void drawScene() {
        ticks++;
        int dx = getWidth();
        int dy = getHeight();

        Rectangle rec = new Rectangle(this.cx-10, this.cy-10, this.cx+this.rad+20, this.cy+this.rad+20);
        this.cx = (this.cx + 1) % dx;
        //repaint(rec);
        repaint();
    }

    private void setup() {
        JFrame frame;

        Rocket r = new Rocket();
        Polygon p = new Polygon(new int[]{-5, 0, 5}, new int[]{10, -10, 10}, 3);
        r.setPoly(p);
        this.myOb = r;

        frame = new JFrame("DNA Rockets");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        executor.scheduleAtFixedRate(() -> this.drawScene(), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] arg) {
        Program clasInst = new Program();
        clasInst.setup();
    }
}
