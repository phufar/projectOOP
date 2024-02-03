package GameStage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class StageOne extends StageController {
    static StageController stageEvent = new StageController();
    static JButton bergerMenu = new JButton();
    static JLabel scoreLabel = new JLabel();
    public static JFrame stageOne = new JFrame() ;
    

    public StageOne(){

        //setFrame
        stageOne.setSize(1280,720);
        stageOne.setTitle("Stage 1");
        stageOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stageOne.setLocationRelativeTo(null);
        stageOne.setUndecorated(true);

        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();

        //LEVEL TEXT
        JLabel levelText = new JLabel("LEVEL");
        levelText.setFont(new Font("Inter", Font.BOLD, 30));
        levelText.setForeground(new Color(58,58,58));
        levelText.setBounds(1070,30,175,50);
        layeredPane.add(levelText,JLayeredPane.DEFAULT_LAYER);
        
        //SCORE
        
        scoreLabel.setText(""+score);
        scoreLabel.setFont(new Font("Inter", Font.BOLD, 30));
        scoreLabel.setForeground(new Color(58,58,58));
        scoreLabel.setBounds(1180,30,50,50);
        layeredPane.add(scoreLabel,JLayeredPane.DEFAULT_LAYER);

        //TEST COUNT BTN
        JButton PlusOne = new JButton("COUNT");
        PlusOne.setBounds(stageOne.getWidth()/2, stageOne.getHeight()/2, 100, 100);
        PlusOne.addActionListener(stageEvent);
        layeredPane.add(PlusOne,JLayeredPane.DEFAULT_LAYER);


        //Hamberger-Menu
        bergerMenu.setIcon(new ImageIcon("img/menu.png"));
        bergerMenu.setBounds(30, 30, 50, 50);
        bergerMenu.setBorder(null);
        bergerMenu.setBorderPainted(false);
        bergerMenu.setContentAreaFilled(false);
        bergerMenu.addActionListener(stageEvent);
        layeredPane.add(bergerMenu, JLayeredPane.DEFAULT_LAYER);

        //Panel-ScoreBoard
        JPanel panelScoreBoard = new JPanel();
        panelScoreBoard.setBackground(new Color(217, 217, 217));
        panelScoreBoard.setBounds(1060, 30, 175, 50);
        layeredPane.add(panelScoreBoard, JLayeredPane.DEFAULT_LAYER);


        // TopPanel
        JPanel BottomPanel = new JPanel();
        BottomPanel.setBackground(new Color(44, 44, 44));
        BottomPanel.setBounds(0, 0, 1280, 120);
        layeredPane.add(BottomPanel, JLayeredPane.DEFAULT_LAYER);

        // MainPanel
        JPanel MainPanel = new JPanel();
        MainPanel.setBackground(new Color(255, 224, 224));
        MainPanel.setBounds(0, 0, 1280, 720);
        layeredPane.add(MainPanel, JLayeredPane.DEFAULT_LAYER);

        // Add the layered pane to the frame
        stageOne.getContentPane().add(layeredPane);
        stageOne.setVisible(true);

    }
}
