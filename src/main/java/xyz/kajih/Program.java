package xyz.kajih;
import xyz.kajih.wobj.Rocket;
import xyz.kajih.wobj.Solid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program extends JPanel implements ActionListener {

    private int cx = 0;
    private int cy = 0;
    private int rad = 200;
    private float frameCount = 0;
    private float ticks = 0;

    Solid myOb;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.frameCount++;
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
        myOb.drawRelative(g);

        g.drawString("Framerate:"+this.frameCount /this.ticks, 700, 700);
    }

    private void drawScene() {
        Rectangle rec = new Rectangle(this.cx-10, this.cy-10, this.cx+this.rad+20, this.cy+this.rad+20);
        this.cx = (this.cx + 1) % 800;
        repaint(rec);
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        ticks++;
        drawScene();
    }

    private void setup() {
        Rocket r = new Rocket();
        Polygon p = new Polygon(new int[]{0, 5, 10}, new int[]{20, 0, 20}, 3);
        r.setPoly(p);
        this.myOb = r;

    }

    public static void main(String[] arg) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame;
            Program clasInst = new Program();
            clasInst.setup();

            frame = new JFrame("DNA Rockets");
            frame.add(clasInst);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            int delay = 1; // milliseconds
            Timer timer = new Timer(delay, clasInst);
            timer.setInitialDelay(0); // First timer is immediate.
            timer.start();
        });
    }
}
