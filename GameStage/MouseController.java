package GameStage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import CircleGen.FakeButton;
import CircleGen.RoundedBorder;
public class MouseController implements MouseListener {
    

    public void mouseEntered(MouseEvent e) { 
        FakeButton srcButton = (FakeButton) e.getSource();
        // Color c = srcButton.getBackground();
        // srcButton.setBackground(c);
        srcButton.setForeground(Color.WHITE);
        srcButton.setBorder(new RoundedBorder.RoundedBorderHover(20));
        // srcButton.setBorder(BorderFactory.createEtchedBorder(1));
        
    }  
    public void mouseExited(MouseEvent e) {  
        FakeButton srcButton = (FakeButton) e.getSource();
        // Color c = srcButton.getBackground();
        // srcButton.setBorderPainted(true);
        srcButton.setForeground(null);
        srcButton.setBorder(new RoundedBorder(20));
        // srcButton.setBorder(BorderFactory.createBevelBorder(1));
    }  
    public void mousePressed(MouseEvent e) {  
    }  
    public void mouseReleased(MouseEvent e) {   
    }
    public void mouseClicked(MouseEvent e) {
    }  
}
