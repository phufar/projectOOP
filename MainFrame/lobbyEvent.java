package MainFrame;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
// import javax.swing.JOptionPane;

import GameStage.StageController;
import GameStage.StageOne;

public class lobbyEvent  implements ActionListener {
    public static double TimeCount = 3000;
    public static double counter = TimeCount;
    public static Timer timer;
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton srcButton = (JButton) e.getSource(); 


        if (srcButton.getText().equals("START")) {
            StageController.playSound("img/pop2-1.wav");
            START();
        } 
        else if (srcButton.getText().equals("OPTION")) {
            StageController.playSound("img/pop2-1.wav");
            OPTION();
        } 
        else if (srcButton.getText().equals("QUIT")) {
            StageController.playSound("img/pop2-1.wav");
            QUIT();
        }
        else if(srcButton.getText().equals("BACK")){
            StageController.playSound("img/pop2-1.wav");
            BACK();
        }
        
    }

    private void START() {
        Lobby.frameLobby.dispose();
        new StageOne();
        lobbyEvent.counter = TimeCount;
        SliderTransition();
    }

    private void OPTION() {
        Lobby.frameLobby.dispose();
        new Option();
    }

    private void QUIT() {
        System.exit(0);
    }


    public static void SliderTransition(){
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            
            public void run(){
                System.out.println((int)counter);
                StageOne.pgBAR.setValue((int)counter);
                counter-=1;
                if(counter < 0){
                    System.out.println("Stop");
                    timer.cancel();
                    StageOne.stageOne.setEnabled(false);
                    StageController.lose();
                }
            }
        }, 0, 5);

    }
    //In option Scene
    private void BACK(){
        Option.frameOption.dispose();
        new Lobby();
    }


}


