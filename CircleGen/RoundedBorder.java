package CircleGen;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.AbstractBorder;

public class RoundedBorder extends AbstractBorder {
    private int radius;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(c.getBackground());
        g2d.fillRoundRect(x, y, width - 1, height - 1, radius, radius);

        g2d.setColor(c.getForeground());
        g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);

        g2d.dispose();
    }

    static public class RoundedBorderHover extends AbstractBorder {
        private int radius;

        public RoundedBorderHover(int radius) {
        this.radius = radius;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(c.getBackground());
        g2d.fillRoundRect(x, y, width - 1, height - 1, radius, radius);

        g2d.setColor(c.getForeground());
        for (int i = 0; i < 3; i++) {
            g2d.drawRoundRect(x + i, y + i, width - (1 + (i*2)), height - (1 + (i*2)), radius , radius);
        }

        g2d.dispose();
        }
    }
}
