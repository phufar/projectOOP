package MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
        JOptionPane.showMessageDialog(null, "START!!!");
    }

    private void OPTION() {
        // JOptionPane.showMessageDialog(null, "OPTION!!!");
        Lobby.frameLobby.setVisible(false);
        Lobby.frameLobby.dispose();
        new Option();
    }

    private void QUIT() {
        // JOptionPane.showMessageDialog(null, "QUIT!!!");
        System.exit(0);
    }
    private void BACK(){
        // JOptionPane.showMessageDialog(null, "BACK!!!");
        new Lobby();
        Option.frameOption.setVisible(false);
        Option.frameOption.dispose();
    }

}
