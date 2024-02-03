package CircleGen;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

public class FakeButton extends JButton{
    boolean target = false;
    public FakeButton(){
        setOpaque(false);
    }
    public void setTarget(boolean t){
        this.target=t;
    }
    public boolean isTarget(){
        return this.target;
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Set rendering hints for better quality
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int diameter = Math.min(getWidth(), getHeight());
        Shape circle = new Ellipse2D.Double(0, 0, diameter, diameter);

        // Set the background color
        g2.setColor(getBackground());
        g2.fill(circle);

        // Set the border color
        g2.setColor(getForeground());
        g2.setStroke(new BasicStroke(2)); // You can adjust the border thickness
        g2.draw(circle);

        g2.dispose();
        super.paintComponent(g);
    }

}
