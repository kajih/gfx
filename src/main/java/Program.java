import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program extends JPanel implements ActionListener {

    private int cx = 0;
    private int cy = 0;
    private int rad = 200;
    private float framecount = 0;
    private float ticks = 0;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.framecount++;

        setBackground(Color.black);
        setForeground(Color.white);

        //g.drawLine(10, 10, 200, 300);
        g.drawOval(this.cx,this.cy, this.rad, this.rad);
        g.fillOval(this.cx+10,this.cy+10, this.rad-20, this.rad-20);
        g.drawRect(this.cx,this.cy, this.rad, this.rad);

        g.drawString("Framerate:"+this.framecount/this.ticks, 700, 700);
    }

    private void drawScene() {

        Rectangle rec = new Rectangle(this.cx-10, this.cy-10, this.cx+this.rad+20, this.cy+this.rad+20);

        this.cx = (this.cx + 1) % 800;
        //repaint(rec);

        repaint();
    }


    public void actionPerformed(ActionEvent e) {

        ticks++;

        drawScene();
    }

    public static void main(String[] arg) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame;
            Program progClass = new Program();

            frame = new JFrame("DNA Rockets");
            frame.add(progClass);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            int delay = 1; // milliseconds
            Timer timer = new Timer(delay, progClass);
            timer.setInitialDelay(0); // First timer is immediate.
            timer.start();

        });
    }
}
