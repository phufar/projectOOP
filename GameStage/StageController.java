package GameStage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.plaf.nimbus.State;

// import javax.swing.JOptionPane;
import CircleGen.*;
import GameStage.MenuPopup;
import MainFrame.Lobby;


public class StageController extends JFrame implements ActionListener {
    static int ScoreLEVEL = 1;
    String score = Integer.toString(ScoreLEVEL);



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
            // StageOne.resetCircleGen();
            StageOne.stageOne.setVisible(false);
            StageOne.stageOne.dispose();
            new StageOne();
        }else if(((FakeButton)srcButton).isTarget()==false){
            ScoreLEVEL = 0;
            BACKTOLOBBY_STATE_1();
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
        System.out.println("back to game!");
        MenuPopup.menuFrame.dispose();
    }

    private void BACKTOLOBBY_STATE_1(){
        System.out.println("YES!!");
        MenuPopup.menuFrame.dispose();
        StageOne.stageOne.dispose();

        // create lobby menu
        Lobby.frameLobby.setContentPane(new Lobby());
        Lobby.frameLobby.revalidate();
        Lobby.frameLobby.repaint();
        

    }
}

