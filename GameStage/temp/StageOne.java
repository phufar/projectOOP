package GameStage.temp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

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
    static JLabel scoreLabel = new JLabel();
    static JPanel gridPanel = new JPanel(new GridLayout(1, 4));
    public static JFrame stageOne = new JFrame();
    public static ArrayList<FakeButton> FakeButtonGenList = new ArrayList<>();
    public static ArrayList<Integer> randomColor = new ArrayList<>();
    public static boolean hasTarget = false;
    int randomRed;
    int randomGreen;
    int randomBlue;

    public StageOne() {
        hasTarget = false;
        // setFrame
        stageOne.setSize(1280, 720);
        stageOne.setTitle("Stage" + ScoreLEVEL);
        stageOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stageOne.setLocationRelativeTo(null);
        stageOne.setUndecorated(true);

        // Create a JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();

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

        // Circle
        // randomColor.add((int)(Math.random()*255));
        // randomColor.add((int)(Math.random()*255));
        // randomColor.add((int)(Math.random()*255));
        // FakeButtonGenList.add(new
        // CircleGenerate(randomColor.get(0),randomColor.get(1),randomColor.get(2),ScoreLEVEL));
        // (FakeButtonGenList.get(0).getCircleList()).size();
        // gridPanel.setBounds(0, 120, 1280, 660);
        // gridPanel.setBackground(new Color(255, 224, 224));
        // for (FakeButton b : FakeButtonGenList.get(0).getCircleList()) {
        // // b.setBounds(stageOne.getWidth()/2, stageOne.getHeight()/2, 100, 100);
        // b.addActionListener(stageEvent);
        // gridPanel.add(b, JLayeredPane.DEFAULT_LAYER);
        // // layeredPane.add(b);
        // }
        randomColor.add((int) (Math.random() * 255));
        randomColor.add((int) (Math.random() * 255));
        randomColor.add((int) (Math.random() * 255));
        FakeButtonGenList.add(new FakeButton());
        FakeButtonGenList.add(new FakeButton());
        FakeButtonGenList.add(new FakeButton());
        for (FakeButton fakeButton : FakeButtonGenList) {
            fakeButton.setPreferredSize(new Dimension(50, 50));
            fakeButton.setBorder(new RoundedBorder(10));
            fakeButton.setBorderPainted(false);
            fakeButton.addActionListener(stageEvent);
            gridPanel.add(fakeButton, JLayeredPane.DEFAULT_LAYER);
        }
        int i = 0;
        while (hasTarget == false && i < FakeButtonGenList.size()) {
            FakeButtonGenList.get(i).setTarget(Math.random() > 0.5);
            if (FakeButtonGenList.get(i).isTarget()) {
                hasTarget = true;
                break;
            }
            if (FakeButtonGenList.get(i).isTarget() == false && i == FakeButtonGenList.size() - 1) {
                FakeButtonGenList.get(i).setTarget(true);
                hasTarget = true;
                break;
            }
        }
        for (FakeButton fakeButton : FakeButtonGenList) {
            Circle c = new Circle(randomRed, randomGreen, randomBlue);
            if (fakeButton.isTarget()) {
                c.setRedsetGreen(this.randomRed + 10, this.randomGreen + 10);
            }
            c.setRGB();
            fakeButton.setBackground(c.getColor());
        }

        // TEST COUNT BTN
        // JButton PlusOne = new JButton("COUNT");
        // PlusOne.setBounds(stageOne.getWidth()/2, stageOne.getHeight()/2, 100, 100);
        // PlusOne.addActionListener(stageEvent);
        // layeredPane.add(PlusOne,JLayeredPane.DEFAULT_LAYER);

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
        stageOne.setVisible(true);
        stageOne.getLayeredPane().paintAll(null);

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
    void setColor(int Red, int Green, int Blue) {

    }
}