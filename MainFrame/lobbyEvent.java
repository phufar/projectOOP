package MainFrame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
// import javax.swing.JOptionPane;

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
        // JOptionPane.showMessageDialog(null, "START!!!");
        Lobby.frameLobby.setVisible(false);
        Lobby.frameLobby.dispose();

        new StageOne();
        
        
    }

    private void OPTION() {
        Lobby.frameLobby.setVisible(false);
        Lobby.frameLobby.dispose();
        new Option();
    }

    private void QUIT() {
        System.exit(0);
    }
    private void BACK(){
        new Lobby();
        Option.frameOption.setVisible(false);
        Option.frameOption.dispose();
    }

}


