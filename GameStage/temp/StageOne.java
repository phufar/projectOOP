package GameStage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import CircleGen.CircleGenerate;
import CircleGen.FakeButton;
import CircleGen.RoundedBorder;
import color_lab.Circle;

public class StageOne extends StageController {
    static StageController stageEvent = new StageController();
    static JButton bergerMenu = new JButton();
    static JLayeredPane layeredPane = new JLayeredPane();
    static JLabel scoreLabel = new JLabel();
    // static JPanel gridPanel = new JPanel(new GridLayout(1, 4));
    public Random rand = new Random();
    public static JFrame stageOne = new JFrame();
    public static ArrayList<Integer> randomColor = new ArrayList<>();
    
    private static final int GRID_SIZE = 5;
    public static boolean hasTarget = false;
    public JButton[][] buttons;
    public static JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
    int randomRed;
    int randomGreen;
    int randomBlue;
    public int TargetX;
    public int TargetY;

    public StageOne() {

        randomRed = rand.nextInt(255);
        randomGreen = rand.nextInt(255);
        randomBlue = rand.nextInt(255);
        TargetX = makeTargetX();
        TargetY = makeTargetY();
        // setFrame
        stageOne.setSize(1280, 720);
        stageOne.setTitle("Stage" + ScoreLEVEL);
        stageOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stageOne.setLocationRelativeTo(null);
        stageOne.setUndecorated(true);

        // LEVEL TEXT
        JLabel levelText = new JLabel("LEVEL");
        levelText.setFont(new Font("Inter", Font.BOLD, 30));
        levelText.setForeground(new Color(58, 58, 58));
        levelText.setBounds(1070, 30, 175, 50);
        layeredPane.add(levelText, JLayeredPane.DEFAULT_LAYER);

        // SCORE

        scoreLabel.setText("" + score);
        scoreLabel.setFont(new Font("Inter", Font.BOLD, 30));
        scoreLabel.setForeground(new Color(58, 58, 58));
        scoreLabel.setBounds(1180, 30, 50, 50);
        layeredPane.add(scoreLabel, JLayeredPane.DEFAULT_LAYER);
        //
        gridPanel.setBounds(0, 120, 1280, 660);
        gridPanel.setBackground(new Color(255, 224, 224));
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(50,50));
                if (i == TargetX && j == TargetY) {
                    buttons[i][j].setBackground(new Color(randomRed+10,randomGreen+10,randomBlue));
                }else{
                    buttons[i][j].setBackground(new Color(randomRed,randomGreen,randomBlue));
                }
                buttons[i][j].addActionListener(stageEvent);
                gridPanel.add(buttons[i][j],JLayeredPane.DEFAULT_LAYER);

            }
        }

        // Hamberger-Menu
        bergerMenu.setIcon(new ImageIcon("img/menu.png"));
        bergerMenu.setBounds(30, 30, 50, 50);
        bergerMenu.setBorder(null);
        bergerMenu.setBorderPainted(false);
        bergerMenu.setContentAreaFilled(false);
        bergerMenu.addActionListener(stageEvent);
        layeredPane.add(bergerMenu, JLayeredPane.DEFAULT_LAYER);

        // Panel-ScoreBoard
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
        layeredPane.add(gridPanel, JLayeredPane.BOTTOM_ALIGNMENT);
        stageOne.getContentPane().add(layeredPane);
        stageOne.getLayeredPane().paintAll(null);
        stageOne.setVisible(true);

    }

    // public static void resetCircleGen() {
    // randomColor.clear();
    // randomColor.add((int) (Math.random() * 255));
    // randomColor.add((int) (Math.random() * 255));
    // randomColor.add((int) (Math.random() * 255));
    // gridPanel.removeAll();
    // FakeButtonGenList.removeAll(FakeButtonGenList);
    // FakeButtonGenList.add(new CircleGenerate(randomColor.get(0),
    // randomColor.get(1), randomColor.get(2), ScoreLEVEL));
    // for (FakeButton b : FakeButtonGenList.get(0).getCircleList()) {
    // // b.setBounds(stageOne.getWidth()/2, stageOne.getHeight()/2, 100, 100);
    // b.addActionListener(stageEvent);
    // gridPanel.add(b, JLayeredPane.DEFAULT_LAYER);
    // // layeredPane.add(b);
    // }
    // //
    // FakeButtonGenList.get(0).setAll(randomColor.get(0),randomColor.get(1),randomColor.get(2));
    // }
    int makeTargetX() {
        return rand.nextInt(5);
    }

    int makeTargetY() {
        return rand.nextInt(5);
    }
}