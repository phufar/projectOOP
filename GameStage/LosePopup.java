package GameStage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class LosePopup extends StageController{
    static JFrame loseFrame;//
    static JPanel losePanel;//
    static JLabel gameover;//
    static JLabel endScore;
    static JLabel TextOver_LEVEL;
    static JButton newGame;//
    static JLayeredPane layer = new JLayeredPane();
    
    
    static StageController stageEvent;
    public LosePopup(){

        stageEvent = new StageController();
        //frame setup
        loseFrame = new JFrame();
        loseFrame.setSize(500,500);
        loseFrame.setTitle("GAMEOVER");
        loseFrame.setLocationRelativeTo(null);
        loseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        gameover = new JLabel("GAME OVER");
        gameover.setBounds(155, 50, 200, 80);
        gameover.setFont(new Font("Inter", Font.BOLD, 30));
        layer.add(gameover, JLayeredPane.DEFAULT_LAYER);
        
        TextOver_LEVEL = new JLabel("HIGH LEVEL:");
        TextOver_LEVEL.setBounds(100, 170, 200, 80);
        TextOver_LEVEL.setFont(new Font("Inter", Font.BOLD, 30));
        layer.add(TextOver_LEVEL, JLayeredPane.DEFAULT_LAYER);

        endScore = new JLabel(StageController.score);
        endScore.setBounds(310, 170, 200, 80);
        endScore.setFont(new Font("Inter", Font.BOLD, 30));
        layer.add(endScore, JLayeredPane.DEFAULT_LAYER);

        //BTN
        newGame = new JButton("NEW GAME");
        newGame.setFont(new Font("Inter", Font.BOLD, 30));
        newGame.setForeground(Color.WHITE);
        newGame.setBounds(145, 320, 200, 80);
        newGame.setBorder(null);
        newGame.setFocusable(false);
        newGame.setBackground(new Color(147,147,147));
        newGame.addActionListener(stageEvent);
        layer.add(newGame, JLayeredPane.DEFAULT_LAYER);

        //losePanel
        losePanel = new JPanel();
        losePanel.setBackground(new Color(217, 217, 217));
        losePanel.setBounds(0, 0, 500, 500);
        layer.add(losePanel, JLayeredPane.DEFAULT_LAYER);

        loseFrame.getContentPane().add(layer);
        loseFrame.setVisible(false);

        
    }


}

// class newdsadsad implements ActionListener {

//     @Override
//     public void actionPerformed(ActionEvent e) {

//         JButton src = (JButton) e.getSource();

//         if(src == LosePopup.newGame){
//             LosePopup.loseFrame.setVisible(false);
//             StageOne.stageOne.dispose();
//             new Lobby();
//         }
//     }
    
// }
