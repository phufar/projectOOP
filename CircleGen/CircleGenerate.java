package CircleGen;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;

import color_lab.Circle;


// class JB extends JButton{
//     boolean isSwap;
// }

public class CircleGenerate extends JFrame{
    private ArrayList<JButton> CircleList = new ArrayList<>();
    
    static int level;
    static float randomrange;
    static float randomHue;
    static float randomSaturation;
    static float randomValue;
    
    // when create object make CircleGenerate(randomHue,randomSaturation,randomValue,getNCircle(level))
    // then CircleGenerate.makeRandomRange(level)


    public CircleGenerate(float randomHue,float randomSaturation,float randomValue,int n) {
        CircleList.clear();
        this.randomHue = randomHue;
        this.randomSaturation = randomSaturation;
        this.randomValue = randomValue;
        int hasTarget =0;
        int makeChange = (int)Math.floor(Math.random()*3);
        makeRandomRange(makeChange);
        
        for(int i = 0; i < n; i++) {
            Circle c = new Circle(randomHue, randomSaturation, randomValue);
            JButton b = new JButton();
            if(hasTarget==0){
                c.setTarget((Math.random()>0.5));
                if(i==n-1){
                    c.setTarget(true);
                }
            }
            if(c.isTarget()){
                switch (makeChange) {
                    case 0://hence hue max is 360 saturation and value is 100
                    c.setHuesetSaturation(randomHue+(float)(3.6*randomrange), randomSaturation+randomrange);
                    c.setValue(randomValue);
                    case 1:
                    c.setSaturationsetValue(randomSaturation+randomrange, randomValue+randomrange);
                    c.setHue(randomValue);
                    case 2:
                    c.setHuesetValue(randomHue+(float)(3.6*randomrange), randomValue+randomrange);
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
        }else if(level>5 && level<=15){
            return 4;
        }else if(level>15 && level<=25){
            return 9;
        }else{
            return 16;
        }
    }
    
    static void makeRandomRange(int level){
        if(level>0 && level <=5){
            randomrange= 50;
        }else if(level>5 && level<=15){
            randomrange= 25;
        }else if(level>15 && level<=25){
            randomrange=15;
        }else{
            randomrange= 10;
        }
    }  
    static void randomPlacement(ArrayList<JButton> CL){
        Collections.shuffle(CL);
    }
}