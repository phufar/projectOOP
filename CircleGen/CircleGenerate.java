package CircleGen;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import color_lab.circle;

public class CircleGenerate extends JFrame{
    private ArrayList<JButton> circleList = new ArrayList<>();


    public CircleGenerate(float hue, float saturation, float value, int n) {
        for(int i = 0; i < n; i++) {
            JButton b = new JButton();
            b.setBackground(Circle);
            circleList.add(b);
            this.add(b);
        }
        this.setVisible(true);
    }

    public void targetColor() {
        System.out.println("eee");
    }

}
