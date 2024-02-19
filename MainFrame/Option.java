package MainFrame;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Font;
// import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Option {

    public static JFrame frameOption;
    static JCheckBox checkBoxMusic;
    public static JSlider sliderBar;
    static JLabel bgm;

    public Option() {
        // Frame
        frameOption = new JFrame();
        frameOption.setTitle("BLIND");
        frameOption.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameOption.setSize(1280, 720);
        frameOption.setLocationRelativeTo(null);
        frameOption.setLayout(null);
        frameOption.setUndecorated(true);

        frameOption.getContentPane().setLayout(new BorderLayout());

        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();

        // Button
        JButton BACK = new JButton("BACK");

        // Set Button
        BACK.setBounds(48, 602, 180, 59);
        BACK.setFocusable(false);

        // set Button Color
        BACK.setBackground(new Color(147, 147, 147));

        // set Button Text
        BACK.setFont(new Font("Inter", Font.BOLD, 32));

        // set button Font-Color
        BACK.setForeground(Color.WHITE);

        // BUTTON EVENT
        lobbyEvent btnEvent = new lobbyEvent();
        BACK.addActionListener(btnEvent);

        // Add a button to Frame
        layeredPane.add(BACK, JLayeredPane.DEFAULT_LAYER);

        //TEXT SLIDER
        bgm = new JLabel("Background Music");
        bgm.setFont(new Font("Inter", Font.BOLD, 30));
        bgm.setForeground(Color.WHITE);
        bgm.setBounds(670,220,300,200);
        layeredPane.add(bgm,JLayeredPane.DEFAULT_LAYER);

        // Slider
        VolumeControl Vctrl = new VolumeControl();
        sliderBar = new JSlider(JSlider.HORIZONTAL, 0, 100, Music.volume);
        sliderBar.setBounds(550, 370, 500, 100);
        sliderBar.addChangeListener(Vctrl);
        sliderBar.setMajorTickSpacing(10);
        sliderBar.setMinimum(0);
        sliderBar.setPaintLabels(true);
        sliderBar.setPaintTicks(true);
        sliderBar.setForeground(Color.white);
        sliderBar.setBackground(new Color(48, 47, 46));
        layeredPane.add(sliderBar, JLayeredPane.DEFAULT_LAYER);

        // Title BLIND
        JLabel nameTitle = new JLabel("OPTION");
        nameTitle.setFont(new Font("Inter", Font.BOLD, 50));
        nameTitle.setForeground(Color.WHITE);
        nameTitle.setBounds(45, 50, 200, 70);
        layeredPane.add(nameTitle, JLayeredPane.DEFAULT_LAYER);

        // LeftPanel
        JPanel LeftPanel = new JPanel();
        LeftPanel.setBackground(new Color(44, 44, 44));
        LeftPanel.setBounds(0, 0, 275, 720);
        layeredPane.add(LeftPanel, JLayeredPane.DEFAULT_LAYER);

        // BottomPanel
        JPanel BottomPanel = new JPanel();
        BottomPanel.setBackground(new Color(48, 47, 46));
        BottomPanel.setBounds(0, 560, 1280, 160);
        layeredPane.add(BottomPanel, JLayeredPane.DEFAULT_LAYER);

        // MainPanel
        JPanel MainPanel = new JPanel();
        MainPanel.setBackground(new Color(48, 47, 46));
        MainPanel.setSize(1280, 720);
        MainPanel.setBounds(0, 0, 1280, 720);
        layeredPane.add(MainPanel, JLayeredPane.DEFAULT_LAYER);

        // Add the layered pane to the frame
        frameOption.getContentPane().add(layeredPane);
        frameOption.setVisible(true);
    }
}


