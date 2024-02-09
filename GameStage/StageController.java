package GameStage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;

import CircleGen.*;
import MainFrame.Lobby;
import MainFrame.lobbyEvent;


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
            playSound("img/pop2-1.wav");
            MENUPOPUP();
        }
        else if(srcButton.getText().equals("LOBBY")){
            lobbyEvent.timer.cancel();
            playSound("img/pop2-1.wav");
            BACKTOLOBBY_STATE_1();
        }
        else if(srcButton.getText().equals("BACK")){
            playSound("img/pop2-1.wav");
            BACKTOGAME();
        }
        else if(srcButton.getText().equals("NEW GAME")) {
            playSound("img/pop2-1.wav");
            // LosePopup.loseFrame.setVisible(false);
            LosePopup.endScore = null;
            LosePopup.losePanel = null;
            LosePopup.loseFrame.dispose();
            StageOne.stageOne.dispose();
            new Lobby();
        }
        else if((srcButton instanceof FakeButton) && ((FakeButton)srcButton).isTarget()==true){
            playSound("img/pop2-1.wav");
            COUNT();
            StageOne.resetCircle();
            lobbyEvent.counter = lobbyEvent.TimeCount;
        }
        else if(((srcButton instanceof FakeButton) && ((FakeButton)srcButton).isTarget()==false)){
            playSound("img/incorrect.wav");
            lobbyEvent.timer.cancel();
            StageOne.stageOne.setEnabled(false);
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
        StageController.playSound("img/pop2-1.wav");
        new MenuPopup();
    }
    private void BACKTOGAME(){
        StageController.playSound("img/pop2-1.wav");
        MenuPopup.menuFrame.setVisible(false);
        MenuPopup.menuFrame.dispose();
    }

    private void BACKTOLOBBY_STATE_1(){
        StageController.playSound("img/pop2-1.wav");
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

    public static void lose(){
        maxScoreCheck();
        ScoreLEVEL = 0;
        new LosePopup();
        ScoreLEVEL = 1;
        score = Integer.toString(ScoreLEVEL);
    }

    private static void maxScoreCheck() {
        if (Integer.parseInt(scoreMax) < ScoreLEVEL) {
            scoreMax = Integer.toString(ScoreLEVEL);
        }
        System.out.println(scoreMax);
    }
    public static void playSound(String filename) {
        try {
            File soundFile = new File(filename);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    
   
}