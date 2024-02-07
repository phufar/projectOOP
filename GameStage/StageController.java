package GameStage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// import javax.swing.JOptionPane;
import CircleGen.*;
import MainFrame.Lobby;


public class StageController extends JFrame implements ActionListener {
    static int ScoreLEVEL = 1;
    static String scoreMax = Integer.toString(ScoreLEVEL);
    static String score = Integer.toString(ScoreLEVEL);

    @Override
    public void actionPerformed(ActionEvent e){
        JButton srcButton = (JButton) e.getSource();
        if(srcButton.getText().equals("COUNT")){
            COUNT();
        }
        else if(srcButton == StageOne.bergerMenu){
            MENUPOPUP();
        }
        else if(srcButton.getText().equals("LOBBY")){
            BACKTOLOBBY_STATE_1();
        }
        else if(srcButton.getText().equals("BACK")){
            BACKTOGAME();
        }
        else if(srcButton.getText().equals("NEW GAME")) {
            // LosePopup.loseFrame.setVisible(false);
            LosePopup.endScore = null;
            LosePopup.losePanel = null;
            LosePopup.loseFrame.dispose();
            StageOne.stageOne.dispose();
            new StageOne();
        }
        else if((srcButton instanceof FakeButton) && ((FakeButton)srcButton).isTarget()==true){
            COUNT();
            StageOne.resetCircle();
        }
        else if((srcButton instanceof FakeButton) && ((FakeButton)srcButton).isTarget()==false){
            lose();
        }
    }

    private void COUNT(){
        ScoreLEVEL+=1;
        score = Integer.toString(ScoreLEVEL);
        StageOne.scoreLabel.setText(""+score);
        System.out.println("Score: "+score);
        System.out.println("ScoreLEVEL: "+ScoreLEVEL);
    }
    private void MENUPOPUP(){
        new MenuPopup();
    }
    private void BACKTOGAME(){
        MenuPopup.menuFrame.setVisible(false);
        MenuPopup.menuFrame.dispose();
    }

    private void BACKTOLOBBY_STATE_1(){
        System.out.println("YES!!");
        maxScoreCheck();
        ScoreLEVEL = 1;
        score = Integer.toString(ScoreLEVEL);
        // remove menu bar if pressed
        MenuPopup.menuFrame.setVisible(false);
        MenuPopup.menuFrame.dispose();

        // remove stage 1 tab
        StageOne.stageOne.dispose();
        new Lobby();
    }

    private void lose(){
        maxScoreCheck();
        ScoreLEVEL = 0;
        new LosePopup();
        ScoreLEVEL = 1;
        score = Integer.toString(ScoreLEVEL);
    }

    private void maxScoreCheck() {
        if (Integer.parseInt(scoreMax) < ScoreLEVEL) {
            scoreMax = Integer.toString(ScoreLEVEL);
        }
        System.out.println(scoreMax);
    }
   
}