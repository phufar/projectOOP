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
        }else if(((FakeButton)srcButton).isTarget()==true){
            COUNT();
            StageOne.resetCircle();
            // this.paintAll(getGraphics());
        
        }else if(((FakeButton)srcButton).isTarget()==false){
            ScoreLEVEL =0;
            StageOne.stageOne.dispose();
            new Lobby();
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

        // remove menu bar if pressed
        MenuPopup.menuFrame.setVisible(false);
        MenuPopup.menuFrame.dispose();

        // remove stage 1 tab
        StageOne.stageOne.dispose();

        // create lobby menu
        // Lobby.frameLobby.setContentPane(new Lobby());
        // Lobby.frameLobby.revalidate();
        // Lobby.frameLobby.repaint();
        
        new Lobby();

    }
}