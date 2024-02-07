package MainFrame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
// import javax.swing.JOptionPane;

import GameStage.LosePopup;
import GameStage.StageOne;

public class lobbyEvent implements ActionListener {
    
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
        // new LosePopup();
    }

    private void OPTION() {
        Lobby.frameLobby.dispose();
        new Option();
    }

    private void QUIT() {
        System.exit(0);
    }


    //In option Scene
    private void BACK(){
        Option.frameOption.dispose();
        new Lobby();
    }

}


