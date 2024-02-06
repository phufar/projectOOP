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
import CircleGen.FakeButton;
import CircleGen.RoundedBorder;

public class StageOne extends StageController {
    static StageController stageEvent;
    static JButton bergerMenu;
    static JLayeredPane layeredPane;
    static JLabel scoreLabel;
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

    static void setGRID_SIZE() {
        if (ScoreLEVEL < 5) {
            GRID_SIZE = 2;
        } else if (ScoreLEVEL < 15) {
            GRID_SIZE = 3;
        } else if (ScoreLEVEL < 25) {
            GRID_SIZE = 4;
        } else {
            GRID_SIZE = 5;
        }
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

    public StageOne() {
        //set up variable
        rand = new Random();
        buttons = null;
        randomRed = rand.nextInt(225);
        randomGreen = rand.nextInt(225);
        randomBlue = rand.nextInt(225);
        TargetX = makeTargetX();
        TargetY = makeTargetY();
        buttons = new FakeButton[GRID_SIZE][GRID_SIZE];
        //init Stage
        stageEvent = new StageController();
        bergerMenu = new JButton();
        layeredPane = new JLayeredPane();
        scoreLabel = new JLabel();
        stageOne = new JFrame();
        // static JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE,15,15));
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
        gridPanel.setBounds(365, 150, 550, 550);
        gridPanel.setBackground(new Color(255, 224, 224));
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                buttons[i][j] = new FakeButton();
                buttons[i][j].setPreferredSize(new Dimension(20, 20));
                buttons[i][j].setBorder(new RoundedBorder(10));
                if (i == TargetX && j == TargetY) {
                    buttons[i][j].setTarget(true);
                    buttons[i][j].setBackground(new Color(randomRed + SetRandomRange(), randomGreen + SetRandomRange(),
                            randomBlue + SetRandomRange()));
                    System.out.println(SetRandomRange() + " " + (int) (randomRed + SetRandomRange()) + " "
                            + (int) (randomGreen + SetRandomRange()) + " " + (int) (randomBlue + SetRandomRange()));
                } else {
                    buttons[i][j].setBackground(new Color(randomRed, randomGreen, randomBlue));
                }
                buttons[i][j].addActionListener(stageEvent);
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
        this.paintAll(getGraphics());

    }

    static int makeTargetX() {
        return rand.nextInt(GRID_SIZE);
    }

    static int makeTargetY() {
        return rand.nextInt(GRID_SIZE);
    }

    public static void resetCircle() {
        // gridPanel.setVisible(false);
        // layeredPane.remove(gridPanel);
        // gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        // layeredPane.add(gridPanel);
        buttons[TargetX][TargetY].setTarget(false);
        // setGRID_SIZE();
        // buttons = new FakeButton[GRID_SIZE][GRID_SIZE];
        randomRed = rand.nextInt(225);
        randomGreen = rand.nextInt(225);
        randomBlue = rand.nextInt(225);
        TargetX = makeTargetX();
        TargetY = makeTargetY();
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (i == TargetX && j == TargetY) {
                    buttons[i][j].setTarget(true);
                    buttons[i][j].setBackground(new Color(randomRed + SetRandomRange(), randomGreen + SetRandomRange(),
                            randomBlue + SetRandomRange()));
                    System.out.println(SetRandomRange() + " " + (int) (randomRed + SetRandomRange()) + " "
                            + (int) (randomGreen + SetRandomRange()) + " " + (int) (randomBlue + SetRandomRange()));
                } else {
                    buttons[i][j].setBackground(new Color(randomRed, randomGreen, randomBlue));
                }
            }
        }
    }
}