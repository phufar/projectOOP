package color_lab;

import java.awt.Color;

public class Circle {
    private int red, green, blue;
    private boolean target = false;
    private Color color;

    public Circle(int red,int green,int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void setRGB() {
        color = new Color(red,green,blue);
    }

    public void setRedsetGreen(int red, int green) {
        this.red = red;
        this.green = green;
        setCheck();
    }

    public void setRedsetBlue(int red, int blue) {
        this.red = red;
        this.blue = blue;
        setCheck();
    }

    public void setGreensetBlue(int green, int blue) {
        this.green = green;
        this.blue = blue;
        setCheck();
    }

    public void setCheck(){
        if(getRed()>255){
            setRed(255);
        }
        if(getGreen()>255){
            setGreen(255);
        }
        if(getBlue()>255){
            setBlue(255);
        }
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }

    public boolean isTarget() {
        return target;
    }

    public Color getColor() {
        return color;
    }



}
