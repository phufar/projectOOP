package CircleGen;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import color_lab.Circle;

public class CircleGenerate extends JFrame {
    public static ArrayList<FakeButton> CircleList = new ArrayList<>();

    static int level;
    int randomRange;
    int randomRed;
    int randomGreen;
    int randomBlue;
    boolean hasTarget = false;
    static int k =0;

    public CircleGenerate(int randomRed, int randomGreen, int randomBlue, int n) {
        k++;
        CircleList.clear();
        System.out.println("I spawn "+k);
        n = CircleGenerate.getNCircle(n);
        System.out.println(randomRed);
        System.out.println(randomGreen);
        System.out.println(randomBlue);
        this.randomRed = randomRed;
        this.randomGreen = randomGreen;
        this.randomBlue = randomBlue;
        this.randomRange = 10;

        for (int i = 0; i < n; i++) {
            Circle c = new Circle(randomRed, randomGreen, randomBlue);
            FakeButton b = new FakeButton();
            if (hasTarget==false) {
                b.setTarget((Math.random() > 0.5));
                if(b.isTarget()){
                    hasTarget=true;
                    c.setRedsetGreen(this.randomRed + this.randomRange, this.randomGreen + randomRange);
                    c.setBlue(this.randomBlue);
                }
            }
            if (i == n - 1 && hasTarget==false) {
                b.setTarget(true);
                hasTarget=true;
                c.setRedsetGreen(this.randomRed + this.randomRange, this.randomGreen + randomRange);
                c.setBlue(this.randomBlue);
            }
            b.setPreferredSize(new Dimension(50, 50));
            b.setBorder(new RoundedBorder(10));
            c.setRGB();
            b.setBorderPainted(false);
            b.setBackground(c.getColor());
            CircleList.add(b);
            this.add(b);
        }

        randomPlacement(CircleList);
    }

    static int getNCircle(int level) {
        if (level > 0 && level <= 5) {
            return 3;
        } else if (level > 5 && level <= 15) {
            return 4;
        } else if (level > 15 && level <= 25) {
            return 9;
        } else {
            return 16;
        }
    }

    public ArrayList<FakeButton> getCircleList() {
        return CircleList;
    }

    static void randomPlacement(ArrayList<FakeButton> CL) {
        Collections.shuffle(CL);
    }
    public void setAll(int randomRed, int randomGreen, int randomBlue){
        this.randomRed = randomRed;
        this.randomGreen = randomGreen;
        this.randomBlue = randomBlue;
    }

}