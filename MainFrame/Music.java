package MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JCheckBox;

public class Music {
    static Clip clip;

    public Music() {
        playMusic("img/Bluelemonade.wav");

    }

    public static void playMusic(String filename) {
        try {
            File soundFile;
            soundFile = new File(filename);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
class MusicControl implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
        JCheckBox chBox = (JCheckBox) e.getSource();
        
        if(chBox == Option.checkBoxMusic ){
            if (Music.clip != null && Music.clip.isRunning()) {
                Music.clip.stop();
            }
            else{
                Music.clip.start();
            }
        }
	}

}
