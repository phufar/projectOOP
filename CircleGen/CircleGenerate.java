package CircleGen;

import java.util.ArrayList;

import javax.swing.JFrame;

public class CircleGenerate extends JFrame{
    ArrayList<Circle> circleList = new ArrayList<>();


    public CircleGenerate(int n) {
        for(int i = 0; i < n; i++) {
            Circle c = new Circle();
            this.add(c);
        }
        this.setVisible(true);
    }

    public void targetColor() {
        System.out.println("eee");
    }

}
