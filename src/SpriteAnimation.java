import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpriteAnimation extends JPanel implements ActionListener {
    private int x = 0;
    private int y = 150;
    private final int DELAY = 10;
    private Timer timer;

    public SpriteAnimation() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSprite(g);
    }

    private void drawSprite(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1;
        if (x > getWidth()) {
            x = -50;
        }
        y = 150 + (int) (50 * Math.sin(x * 0.1));
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sprite Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SpriteAnimation());
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}