package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Lobby extends JFrame {

    JFrame frame = new JFrame();

    public Lobby() {
        // Frame
        this.setTitle("BLIND");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout());
        this.setVisible(true);

        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();

        // Button
        JButton Start = new JButton("START");
        JButton Option = new JButton("OPTION");
        JButton Quit = new JButton("QUIT");

        // Set Button
        Start.setBounds(48, 442, 180, 59);
        Option.setBounds(48, 522, 180, 59);
        Quit.setBounds(48, 602, 180, 59);

        // set Button Color
        Start.setBackground(new Color(147, 147, 147));
        Option.setBackground(new Color(147, 147, 147));
        Quit.setBackground(new Color(147, 147, 147));

        //set Button Text
        Start.setFont(new Font("Inter", Font.BOLD, 32));
        Option.setFont(new Font("Inter", Font.BOLD, 32));
        Quit.setFont(new Font("Inter", Font.BOLD, 32));
        
        //set button Font-Color
        Start.setForeground(Color.WHITE);
        Option.setForeground(Color.WHITE);
        Quit.setForeground(Color.WHITE);

        //BUTTON EVENT
        lobbyEvent btnEvent = new lobbyEvent();
        Start.addActionListener(btnEvent);
        Option.addActionListener(btnEvent);
        Quit.addActionListener(btnEvent);

        // Add a button to Frame
        layeredPane.add(Start, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(Option, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(Quit, JLayeredPane.DEFAULT_LAYER);

        // Title BLIND
        JLabel nameTitle = new JLabel("BLIND");
        nameTitle.setFont(new Font("Inter", Font.BOLD, 60));
        nameTitle.setForeground(Color.WHITE);
        nameTitle.setBounds(48, 50, 200, 70);
        layeredPane.add(nameTitle, JLayeredPane.DEFAULT_LAYER);

        // LeftPanel
        JPanel LeftPanel = new JPanel();
        LeftPanel.setBackground(new Color(44, 44, 44));
        LeftPanel.setBounds(0, 0, 275, 720);
        layeredPane.add(LeftPanel, JLayeredPane.DEFAULT_LAYER);

        // BottomPanel
        JPanel BottomPanel = new JPanel();
        BottomPanel.setBackground(new Color(235, 216, 216));
        BottomPanel.setBounds(0, 560, 1280, 160);
        layeredPane.add(BottomPanel, JLayeredPane.DEFAULT_LAYER);

        // MainPanel
        JPanel MainPanel = new JPanel();
        MainPanel.setBackground(new Color(255, 224, 224));
        MainPanel.setSize(1280, 720);
        MainPanel.setBounds(0, 0, 1280, 720);
        layeredPane.add(MainPanel, JLayeredPane.DEFAULT_LAYER);

        // Add the layered pane to the frame
        this.getContentPane().add(layeredPane);

    }

}
