package CircleGen;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import color_lab.Circle;

public class CircleGenerate extends JFrame{
    private ArrayList<JButton> CircleList = new ArrayList<>();
    
    static int level;
    static float randomrange;
    static float randomHue;
    static float randomSaturation;
    static float randomValue;

    public CircleGenerate(float randomHue,float randomSaturation,float randomValue,int n) {
        int hasTarget =0;
        int makeChange = (int)Math.floor(Math.random()*3);
        for(int i = 0; i < n; i++) {
            JButton b = new JButton();
            Circle c = new Circle(randomHue, randomSaturation, randomValue);
            if(hasTarget==0){
                c.setTarget((Math.random()>0.5));
                if(i==n-1){
                    c.setTarget(true);
                }
            }
            if(c.isTarget()){
                switch (makeChange) {
                    case 0:
                        c.setHuesetSaturation(randomHue+randomrange, randomSaturation+randomrange);
                        c.setValue(randomValue);
                    case 1:
                        c.setSaturationsetValue(randomSaturation+randomrange, randomValue+randomrange);
                        c.setHue(randomValue);
                    case 2:
                        c.setHuesetValue(randomHue+randomrange, randomValue+randomrange);
                        c.setSaturation(randomSaturation);
                }
            }
            c.setRGB();
            b.setBackground(c.getC());
            CircleList.add(b);
            this.add(b);
        }

        this.setVisible(true);
    }
    
    static int getNCircle(int level){
        if(level>0 && level <=5){
            return 2;
        }else if(level>5 && level<=10){
            return 4;
        }else if(level>10 && level<=15){
            return 9;
        }else{
            return 16;
        }
    }
    
    static float makeRandomRange(int level){
        return 0;  //will implements later
    }   
}