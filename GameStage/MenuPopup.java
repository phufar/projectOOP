package GameStage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MenuPopup extends StageController {

    // Btn-Element
    static JFrame menuFrame;
    static JButton MenuLobby;
    static JButton BACTOGAME;
    static StageController stageEvent;
    static JPanel MainMenuPanel;

    public MenuPopup() {

        StageController stageEvent = new StageController();

        menuFrame = new JFrame();
        menuFrame.setSize(500, 500);
        menuFrame.setTitle("MENUFRAME");
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setUndecorated(true);
        menuFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();

        // Add Button
        MenuLobby = new JButton("LOBBY");
        MenuLobby.setBounds(150, 120, 200, 80);
        MenuLobby.setForeground(new Color(60, 60, 60));
        MenuLobby.setFont(new Font("Inter", Font.BOLD, 30));
        MenuLobby.setBorder(null);
        MenuLobby.setFocusable(false);
        MenuLobby.setBackground(new Color(217, 217, 217));
        MenuLobby.addActionListener(stageEvent);
        layeredPane.add(MenuLobby, JLayeredPane.DEFAULT_LAYER);

        BACTOGAME = new JButton("BACK");
        BACTOGAME.setFont(new Font("Inter", Font.BOLD, 30));
        BACTOGAME.setForeground(new Color(60, 60, 60));
        BACTOGAME.setBounds(150, 260, 200, 80);
        BACTOGAME.setBorder(null);
        BACTOGAME.setFocusable(false);
        BACTOGAME.setBackground(new Color(217, 217, 217));
        layeredPane.add(BACTOGAME, JLayeredPane.DEFAULT_LAYER);

        // MainPanel
        JPanel MainMenuPanel = new JPanel();
        MainMenuPanel.setBackground(new Color(60, 60, 60));
        MainMenuPanel.setBounds(0, 0, 500, 500);
        layeredPane.add(MainMenuPanel, JLayeredPane.DEFAULT_LAYER);

        BACTOGAME.addActionListener(stageEvent);

        menuFrame.getContentPane().add(layeredPane);
        menuFrame.setVisible(true);
    }
}
