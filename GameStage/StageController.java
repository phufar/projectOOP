package GameStage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
// import javax.swing.JOptionPane;
import CircleGen.*;


import MainFrame.Lobby;
import MainFrame.Option;
import color_lab.Circle;


public class StageController implements ActionListener {
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
        }
        else if(srcButton.getText().equals("OPTION")){
                OPTION();
        }
        else if(((FakeButton)srcButton).isTarget()){
            COUNT();
            StageOne.resetCircleGen();
            StageOne.stageOne.setVisible(false);
            StageOne.stageOne.dispose();
            new StageOne();
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
    private void OPTION() {
        System.out.println("Your was Click Option!!!");

    }
    private void BACKTOLOBBY_STATE_1(){
        System.out.println("YES!!");
        MenuPopup.menuFrame.setVisible(false);
        MenuPopup.menuFrame.dispose();

        Lobby.frameLobby.setContentPane(new Lobby());
        Lobby.frameLobby.revalidate();
        Lobby.frameLobby.repaint();
    }
}

