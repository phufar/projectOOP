package GameStage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import CircleGen.FakeButton;
public class MouseController implements MouseListener {
    public void mouseEntered(MouseEvent e) { 
        FakeButton srcButton = (FakeButton) e.getSource();
        Color c = srcButton.getBackground();
        srcButton.setBorder(BorderFactory.createLineBorder(Color.white));

    }  
    public void mouseExited(MouseEvent e) {  
        FakeButton srcButton = (FakeButton) e.getSource();
        Color c = srcButton.getBackground();
        srcButton.setBorderPainted(true);
        srcButton.setBorder(BorderFactory.createLineBorder(srcButton.getBackground()));
    }  
    public void mousePressed(MouseEvent e) {  
    }  
    public void mouseReleased(MouseEvent e) {   
    }
    public void mouseClicked(MouseEvent e) {
    }  
}
