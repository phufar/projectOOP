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
    ArrayList<FakeButton> CircleList = new ArrayList<>();
    
    static int level;
    static int randomrange;
    static int randomRed;
    static int randomGreen;
    static int randomBlue;
    
    // when create object make CircleGenerate(randomRed,randomGreen,randomBlue,getNCircle(level))
    // then CircleGenerate.makeRandomRange(level)


    public CircleGenerate(int randomRed,int randomGreen,int randomBlue,int n) {
        n = CircleGenerate.getNCircle(n);
        CircleList.clear();
        this.randomRed = randomRed;
        this.randomGreen = randomGreen;
        this.randomBlue = randomBlue;
        this.randomrange = 5;
        int hasTarget =0;
        int makeChange = (int)Math.floor(Math.random()*3);
        System.out.println(randomrange);
        System.out.println(String.format("[%s, %s, %s]", randomRed,randomGreen,randomBlue));
        System.out.println(makeChange);
        // makeRandomRange(makeChange);
        
        for(int i = 0; i < n; i++) {
            Circle c = new Circle(randomRed, randomGreen, randomBlue);
            FakeButton b = new FakeButton();
            if(hasTarget==0){
                c.setTarget((Math.random()>0.5));
                if(i==n-1){
                    c.setTarget(true);
                }
            }
            if(c.isTarget()){
                hasTarget++;
                // switch (makeChange) {
                //     case 0://hence Red max is 360 Green and Blue is 100
                //         c.setRedsetGreen(this.randomRed+(int)(3.6*this.randomrange), this.randomGreen+randomrange);
                //         c.setBlue(this.randomBlue);
                //     case 1:
                //     c.setRedsetGreen(this.randomRed+(int)(3.6*this.randomrange), this.randomGreen+randomrange);
                //     c.setBlue(this.randomBlue);
                //     case 2:
                //         c.setRedsetBlue(this.randomRed+(int)(3.6*randomrange), this.randomBlue+randomrange);
                //         c.setGreen(this.randomGreen);
                // }
                if(makeChange==0){
                    c.setRedsetGreen(this.randomRed+this.randomrange, this.randomGreen+randomrange);
                        c.setBlue(this.randomBlue);
                }else if(makeChange == 1){
                    c.setRedsetGreen(this.randomRed+this.randomrange, this.randomGreen+randomrange);
                        c.setBlue(this.randomBlue);
                }else{
                    c.setRedsetBlue(this.randomRed+this.randomrange, this.randomBlue+randomrange);
                        c.setGreen(this.randomGreen);
                }
            }
            System.out.println(c.getRed()+" "+c.getGreen()+" "+c.getBlue());

            c.setRGB();
            b.setBackground(c.getColor());
            // System.out.println(c.isTarget());
            // System.out.println(c.getColor());
            CircleList.add(b);
            this.add(b);
        }

        this.setVisible(true);
    }
    
    static int getNCircle(int level){
        if(level>0 && level <=5){
            return 3;
        }else if(level>5 && level<=15){
            return 4;
        }else if(level>15 && level<=25){
            return 9;
        }else{
            return 16;
        }
    }
    
    // static int makeRandomRange(int level){
    //     if(level>0 && level <=5){
    //         return 10;
    //     }else if(level>5 && level<=15){
    //         return 5;
    //     }else if(level>15 && level<=25){
    //         return 2;
    //     }else{
    //         return 1;
    //     }
    // }

    static void randomPlacement(ArrayList<JButton> CL){
        Collections.shuffle(CL);
    }
}