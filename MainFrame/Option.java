package MainFrame;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Font;
// import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Option {

    public static JFrame frameOption;
    public static JSlider sliderBarMusic;
    public static JSlider sliderBarSound;
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

        //TEXT Music SLIDER
        bgm = new JLabel("Background Music");
        bgm.setFont(new Font("Inter", Font.BOLD, 30));
        bgm.setForeground(Color.WHITE);
        bgm.setBounds(670,320,300,200);
        layeredPane.add(bgm,JLayeredPane.DEFAULT_LAYER);

        // Music Slider
        MusicControl Vctrl = new MusicControl();
        sliderBarMusic = new JSlider(JSlider.HORIZONTAL, 0, 100, Music.MusicVolume);
        sliderBarMusic.setBounds(550, 470, 500, 100);
        sliderBarMusic.addChangeListener(Vctrl);
        sliderBarMusic.setMajorTickSpacing(10);
        sliderBarMusic.setMinimum(0);
        sliderBarMusic.setPaintLabels(true);
        sliderBarMusic.setPaintTicks(true);
        sliderBarMusic.setForeground(Color.white);
        sliderBarMusic.setBackground(new Color(48, 47, 46));
        layeredPane.add(sliderBarMusic, JLayeredPane.DEFAULT_LAYER);
        
        //TEXT Sound SLIDER
        bgm = new JLabel("Sound Effect");
        bgm.setFont(new Font("Inter", Font.BOLD, 30));
        bgm.setForeground(Color.WHITE);
        bgm.setBounds(715,50,300,200);
        layeredPane.add(bgm,JLayeredPane.DEFAULT_LAYER);

        // Sound Slider
        SoundControl Sctrl = new SoundControl();
        sliderBarSound = new JSlider(JSlider.HORIZONTAL, 0, 100, Music.SoundVolume);
        sliderBarSound.setBounds(550, 200, 500, 100);
        sliderBarSound.addChangeListener(Sctrl);
        sliderBarSound.setMajorTickSpacing(10);
        sliderBarSound.setMinimum(0);
        sliderBarSound.setPaintLabels(true);
        sliderBarSound.setPaintTicks(true);
        sliderBarSound.setForeground(Color.white);
        sliderBarSound.setBackground(new Color(48, 47, 46));
        layeredPane.add(sliderBarSound, JLayeredPane.DEFAULT_LAYER);

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


