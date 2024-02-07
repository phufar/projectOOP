package MainFrame;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
// import javax.swing.JOptionPane;

import GameStage.StageController;
import GameStage.StageOne;

public class lobbyEvent implements ActionListener {
    public static double TimeCount = 1000;
    public static double counter = TimeCount;
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton srcButton = (JButton) e.getSource(); 

        if (srcButton.getText().equals("START")) {
            START();
        } 
        else if (srcButton.getText().equals("OPTION")) {
            OPTION();
        } 
        else if (srcButton.getText().equals("QUIT")) {
            QUIT();
        }
        else if(srcButton.getText().equals("BACK")){
            BACK();
        }
    }

    private void START() {
        Lobby.frameLobby.dispose();
        new StageOne();
        lobbyEvent.counter = 1000;
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
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            
            public void run(){
                // System.out.println((int)counter);
                StageOne.pgBAR.setValue((int)counter);
                counter-=2;
                if(counter < 0){
                    System.out.println("Stop");
                    timer.cancel();
                    StageController.lose();
                }
            }
        }, 0, 50);

    }
    //In option Scene
    private void BACK(){
        Option.frameOption.dispose();
        new Lobby();
    }


}


