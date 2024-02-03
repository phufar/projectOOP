package CircleGen;

import javax.swing.JButton;

public class FakeButton extends JButton{
    boolean target = false;
    void setTarget(boolean t){
        this.target=t;
    }
    boolean isTarget(){
        return this.target;
    }
}
