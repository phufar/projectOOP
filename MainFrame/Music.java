package MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

class VolumeControl implements ChangeListener{

    @Override
    public void stateChanged(ChangeEvent e) {
        int volume = (Option.sliderBar).getValue();
        FloatControl gainControl = (FloatControl) (Music.clip).getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log(volume / 100.0) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }

    
    
}
