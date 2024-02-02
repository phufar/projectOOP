package CircleGen;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import color_lab.Circle;

public class CircleGenerate extends JFrame{
    private ArrayList<JButton> CircleList = new ArrayList<>();


    public CircleGenerate(float hue, float saturation, float value, int n) {
        for(int i = 0; i < n; i++) {
            JButton b = new JButton();
            Circle c = new Circle(hue, saturation, value);
            c.setTarget((Math.random()>0.5));
            c.setRGB();
            b.setBackground(c.getC());
            CircleList.add(b);
            this.add(b);
        }

        this.setVisible(true);
    }
}
