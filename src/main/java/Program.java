import javax.swing.*;
import java.awt.*;

public class Program extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.black);
        setForeground(Color.white);
        g.drawLine(10, 10, 200, 300);
    }

    public static void main(String[] arg) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame;
                frame = new JFrame("DNA Rockets");
                frame.add(new Program());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 800);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
