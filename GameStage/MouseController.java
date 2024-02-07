package GameStage;
import java.awt.event.*;

import javax.swing.JButton;
public class MouseController implements MouseListener {
    public void mouseEntered(MouseEvent e) {  
        JButton srcButton = (JButton) e.getSource();
        srcButton.setBorderPainted(true);

    }  
    public void mouseExited(MouseEvent e) {  
        JButton srcButton = (JButton) e.getSource();
        srcButton.setBorderPainted(false);
    }  
    public void mousePressed(MouseEvent e) {  
    }  
    public void mouseReleased(MouseEvent e) {   
    }
    public void mouseClicked(MouseEvent e) {
    }  
}
