package color_lab;

import java.awt.Color;

public class Circle {
    private int red, green, blue;
    private boolean target = false;
    private Color c;

    public Circle(int red,int green,int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // public static Color HexToColor(String hex) {
    //     hex = hex.replace("#", "");
    //     switch (hex.length()) {
    //         case 6:
    //             return new Color(
    //                     Integer.blueOf(hex.substring(0, 2), 16),
    //                     Integer.blueOf(hex.substring(2, 4), 16),
    //                     Integer.blueOf(hex.substring(4, 6), 16));
    //         case 8:
    //             return new Color(
    //                     Integer.blueOf(hex.substring(0, 2), 16),
    //                     Integer.blueOf(hex.substring(2, 4), 16),
    //                     Integer.blueOf(hex.substring(4, 6), 16),
    //                     Integer.blueOf(hex.substring(6, 8), 16));
    //     }
    //     return null;
    // }

    public void setRGB() {
        c = new Color(red,green,blue);
    }

    // public String hsvtoRGB(float H, float S, float V) {
    //     float R, G, B;
    //     H /= 360f;
    //     S /= 100f;
    //     V /= 100f;
    //     if (S == 0) {
    //         R = V * 255;
    //         G = V * 255;
    //         B = V * 255;
    //     } else {
    //         float var_h = H * 6;
    //         if (var_h == 6)
    //             var_h = 0; // H must be < 1
    //         int var_i = (int) Math.floor((double) var_h); // Or ... var_i =
    //                                                       // floor( var_h )
    //         float var_1 = V * (1 - S);
    //         float var_2 = V * (1 - S * (var_h - var_i));
    //         float var_3 = V * (1 - S * (1 - (var_h - var_i)));

    //         float var_r;
    //         float var_g;
    //         float var_b;
    //         if (var_i == 0) {
    //             var_r = V;
    //             var_g = var_3;
    //             var_b = var_1;
    //         } else if (var_i == 1) {
    //             var_r = var_2;
    //             var_g = V;
    //             var_b = var_1;
    //         } else if (var_i == 2) {
    //             var_r = var_1;
    //             var_g = V;
    //             var_b = var_3;
    //         } else if (var_i == 3) {
    //             var_r = var_1;
    //             var_g = var_2;
    //             var_b = V;
    //         } else if (var_i == 4) {
    //             var_r = var_3;
    //             var_g = var_1;
    //             var_b = V;
    //         } else {
    //             var_r = V;
    //             var_g = var_1;
    //             var_b = var_2;
    //         }

    //         R = var_r * 255; // RGB results from 0 to 255
    //         G = var_g * 255;
    //         B = var_b * 255;
    //     }

    //     String rs = Integer.toHexString((int) (R));
    //     String gs = Integer.toHexString((int) (G));
    //     String bs = Integer.toHexString((int) (B));

    //     if (rs.length() == 1)
    //         rs = "0" + rs;
    //     if (gs.length() == 1)
    //         gs = "0" + gs;
    //     if (bs.length() == 1)
    //         bs = "0" + bs;
    //     return "#" + rs + gs + bs;
    // }

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

    public void setC(Color c) {
        this.c = c;
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

    public Color getC() {
        return c;
    }



}
