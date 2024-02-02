package MainFrame;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lobby extends JFrame {
    static JFrame frame;
    static JButton btn1 = new JButton("btn1");
    static JPanel MainPanel = new JPanel();;
    static JPanel BottomPanel = new JPanel();;
    static JPanel LeftPanel;

    public Lobby(){
        //Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //MainPanel
        MainPanel.setBackground(new Color(255,224,224));
        MainPanel.setSize(1280,580);
        this.getContentPane().add(MainPanel);

        //BottomPanel
        BottomPanel.setBackground(new Color(235,216,216));
        BottomPanel.setSize(1280,220);
        this.getContentPane().add(BottomPanel);


        


    }
    
}
