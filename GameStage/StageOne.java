package GameStage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import CircleGen.FakeButton;
import CircleGen.RoundedBorder;
import MainFrame.lobbyEvent;

public class StageOne extends StageController {
    static MouseController mouseEvent;
    static StageController stageEvent;
    static JButton bergerMenu;
    static JLayeredPane layeredPane;
    static JLabel scoreLabel;

    // BAR TIME
    public static JProgressBar pgBAR;

    // BTN CHECK GAME OVER
    static JButton gameover;

    // static JPanel gridPanel = new JPanel(new GridLayout(1, 4));
    public static Random rand;
    public static JFrame stageOne;
    public static ArrayList<Integer> randomColor;

    private static int GRID_SIZE = 5;
    public static FakeButton[][] buttons;
    public static JPanel gridPanel;
    private static int randomRed;
    private static int randomGreen;
    private static int randomBlue;
    public static int TargetX;
    public static int TargetY;
    public static int Time = 10;
    public static int set;

    public StageOne() {

        // set up variable XD
        ScoreLEVEL = 0;
        rand = new Random();
        buttons = null;
        set = rand.nextInt(2);
        randomRed = rand.nextInt(255-SetRandomRange());
        randomGreen = rand.nextInt(255-SetRandomRange());
        randomBlue = rand.nextInt(255-SetRandomRange());
        TargetX = makeTargetX();
        TargetY = makeTargetY();
        buttons = new FakeButton[GRID_SIZE][GRID_SIZE];
        // init Stage
        stageEvent = new StageController();
        mouseEvent = new MouseController();
        bergerMenu = new JButton();
        layeredPane = new JLayeredPane();
        scoreLabel = new JLabel();
        stageOne = new JFrame();
        // static JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE, 10, 10));
        // setFrame
        stageOne.setSize(1280, 720);
        stageOne.setTitle("Stage" + ScoreLEVEL);
        stageOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stageOne.setLocationRelativeTo(null);
        stageOne.setUndecorated(true);
        stageOne.setBackground(Color.black);

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
        gridPanel.setBounds(365, 150, 550, 550);
        gridPanel.setBackground(new Color(48, 47, 46));
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                buttons[i][j] = new FakeButton();
                buttons[i][j].setPreferredSize(new Dimension(20, 20));
                buttons[i][j].setBorder(new RoundedBorder(20));
                buttons[i][j].setContentAreaFilled(false);
                if (set == 0) {
                    if (i == TargetX && j == TargetY) {
                        buttons[i][j].setTarget(true);
                        buttons[i][j]
                                .setBackground(new Color(randomRed + SetRandomRange(), randomGreen + SetRandomRange(),
                                        randomBlue + SetRandomRange()));
                        System.out.println(SetRandomRange() + " " + (int) (randomRed + SetRandomRange()) + " "
                                + (int) (randomGreen + SetRandomRange()) + " " + (int) (randomBlue + SetRandomRange()));
                    } else {
                        buttons[i][j].setBackground(new Color(randomRed, randomGreen, randomBlue));
                    }
                } else {
                    if (i == TargetX && j == TargetY) {
                        buttons[i][j].setTarget(true);
                        buttons[i][j].setBackground(new Color(randomRed, randomGreen,
                                randomBlue));
                        System.out.println(SetRandomRange() + " " + (int) (randomRed + SetRandomRange()) + " "
                                + (int) (randomGreen + SetRandomRange()) + " " + (int) (randomBlue + SetRandomRange()));
                    } else {
                        buttons[i][j].setBackground(new Color(randomRed + SetRandomRange(),
                                randomGreen + SetRandomRange(), randomBlue + SetRandomRange()));
                    }
                }
                buttons[i][j].addActionListener(stageEvent);
                buttons[i][j].addMouseListener(mouseEvent);
                gridPanel.add(buttons[i][j], JLayeredPane.DEFAULT_LAYER);
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

        // progressBar
        pgBAR = new JProgressBar(JProgressBar.HORIZONTAL, 0, (int) lobbyEvent.TimeCount);
        pgBAR.setValue((int) lobbyEvent.TimeCount);
        pgBAR.setBounds(390, 50, 500, 15);
        pgBAR.setForeground(Color.white);
        pgBAR.setBackground(new Color(44, 44, 44));
        pgBAR.setBorderPainted(false);
        layeredPane.add(pgBAR, JLayeredPane.DEFAULT_LAYER);

        // TopPanel
        JPanel BottomPanel = new JPanel();
        BottomPanel.setBackground(new Color(44, 44, 44));
        BottomPanel.setBounds(0, 0, 1280, 120);
        layeredPane.add(BottomPanel, JLayeredPane.DEFAULT_LAYER);

        // Add the layered pane to the frame
        layeredPane.add(gridPanel, JLayeredPane.BOTTOM_ALIGNMENT);
        stageOne.getContentPane().add(layeredPane);
        stageOne.setVisible(true);
        this.paintAll(getGraphics());

        // MainPanel
        JPanel MainPanel = new JPanel();
        MainPanel.setBackground(new Color(48, 47, 46));
        MainPanel.setBounds(0, 0, 1280, 720);
        layeredPane.add(MainPanel, JLayeredPane.DEFAULT_LAYER);
    }

    static int makeTargetX() {
        return rand.nextInt(GRID_SIZE);
    }

    static int makeTargetY() {
        return rand.nextInt(GRID_SIZE);
    }

    static int SetRandomRange() {
        if (ScoreLEVEL < 5) {
            return 30;
        } else if (ScoreLEVEL < 15) {
            return 20;
        } else if (ScoreLEVEL < 25) {
            return 15;
        } else {
            return 8;
        }
    }

    // Reset New Circle
    public static void resetCircle() {
        buttons[TargetX][TargetY].setTarget(false);
        set = rand.nextInt(2);
        randomRed = rand.nextInt(255-SetRandomRange());
        randomGreen = rand.nextInt(255-SetRandomRange());
        randomBlue = rand.nextInt(255-SetRandomRange());
        TargetX = makeTargetX();
        TargetY = makeTargetY();
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (set == 0) {
                    if (i == TargetX && j == TargetY) {
                        buttons[i][j].setTarget(true);
                        buttons[i][j]
                                .setBackground(new Color(randomRed + SetRandomRange(), randomGreen + SetRandomRange(),
                                        randomBlue + SetRandomRange()));
                        System.out.println(SetRandomRange() + " " + (int) (randomRed + SetRandomRange()) + " "
                                + (int) (randomGreen + SetRandomRange()) + " " + (int) (randomBlue + SetRandomRange()));
                    } else {
                        buttons[i][j].setBackground(new Color(randomRed, randomGreen, randomBlue));
                    }
                } else {
                    if (i == TargetX && j == TargetY) {
                        buttons[i][j].setTarget(true);
                        buttons[i][j].setBackground(new Color(randomRed, randomGreen,
                                randomBlue));
                        System.out.println(SetRandomRange() + " " + (int) (randomRed + SetRandomRange()) + " "
                                + (int) (randomGreen + SetRandomRange()) + " " + (int) (randomBlue + SetRandomRange()));
                    } else {
                        buttons[i][j].setBackground(new Color(randomRed + SetRandomRange(),
                                randomGreen + SetRandomRange(), randomBlue + SetRandomRange()));
                    }
                }
            }
        }
    }
}