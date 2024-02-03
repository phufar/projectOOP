package GameStage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
// import javax.swing.JOptionPane;
import CircleGen.*;

public class StageController  implements ActionListener  {
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
        else if(srcButton.getText().equals("BACK")){
            BACKTOGAME();
        }
        // check is target
        else if(((FakeButton)srcButton).isTarget()){
            COUNT();
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
}

