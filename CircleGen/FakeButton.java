package CircleGen;

import javax.swing.JButton;

public class FakeButton extends JButton{
    boolean target = false;
    public void setTarget(boolean t){
        this.target=t;
    }
    public boolean isTarget(){
        return this.target;
    }
}
