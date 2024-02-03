package GameStage;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class MenuPopup {
    
    static JPanel menuPopup = new JPanel();

    MenuPopup(){
        JDialog menuFrame = new JDialog();
        menuFrame.setSize(500,500);
        menuFrame.setUndecorated(true);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        menuFrame.add(menuPopup);

        menuPopup.setBounds(100, 100, 500, 500);
        menuPopup.setBackground(new Color(255, 224, 224));
        menuFrame.add(menuPopup);
        menuFrame.setVisible(true);
    }
}
