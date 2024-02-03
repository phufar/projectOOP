package GameStage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MenuPopup extends StageController {

    static JFrame menuFrame = new JFrame();
    static JButton BACTOGAME;
    public static JButton MenuLobby;
    static StageController stageEvent = new StageController();

    public MenuPopup() {

        
        menuFrame.setSize(500, 500);
        menuFrame.setTitle("MENUFRAME");
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setUndecorated(true);
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();

        // Add Button
        JButton MenuLobby = new JButton("LOBBY");
        MenuLobby.setBounds(150, 70, 200, 80);
        MenuLobby.setForeground(Color.WHITE);
        MenuLobby.setFont(new Font("Inter", Font.BOLD, 30));
        MenuLobby.setBorder(null);
        MenuLobby.setFocusable(false);
        MenuLobby.setBackground(new Color(147,147,147));
        MenuLobby.addActionListener(stageEvent);
        layeredPane.add(MenuLobby, JLayeredPane.DEFAULT_LAYER);

        JButton MenuOption = new JButton("OPTION");
        MenuOption.setBounds(150, 190, 200, 80);
        MenuOption.setForeground(Color.WHITE);
        MenuOption.setFont(new Font("Inter", Font.BOLD, 30));
        MenuOption.setBorder(null);
        MenuOption.setFocusable(false);
        MenuOption.setBackground(new Color(147,147,147));
        layeredPane.add(MenuOption, JLayeredPane.DEFAULT_LAYER);

        JButton BACTOGAME = new JButton("BACK");
        BACTOGAME.setFont(new Font("Inter", Font.BOLD, 30));
        BACTOGAME.setForeground(Color.WHITE);
        BACTOGAME.setBounds(150, 310, 200, 80);
        BACTOGAME.setBorder(null);
        BACTOGAME.setFocusable(false);
        BACTOGAME.setBackground(new Color(147,147,147));
        layeredPane.add(BACTOGAME, JLayeredPane.DEFAULT_LAYER);
        
        // MainPanel
        JPanel MainMenuPanel = new JPanel();
        MainMenuPanel.setBackground(new Color(217, 217, 217));
        MainMenuPanel.setBounds(0, 0, 500, 500);
        layeredPane.add(MainMenuPanel, JLayeredPane.DEFAULT_LAYER);
        
        BACTOGAME.addActionListener(stageEvent);

        menuFrame.getContentPane().add(layeredPane);
        menuFrame.setVisible(true);

    }
}
