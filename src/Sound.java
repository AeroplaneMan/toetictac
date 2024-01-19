import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Sound {
    public Clip clip;

    public void playMusic(String filePath) {
        try{
            File musicPath = new File(filePath); // used to store the sound file

            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath); //input used for the sound
                clip = AudioSystem.getClip(); //initializing the sound to be played
                clip.open(audioInput); //sound is being opened to play
                clip.start(); //plays the sound
            }
            else {
                System.out.println("Can't find file"); //printed when sound file path is incorrect
            }
        }
        catch (Exception e){
            System.out.println(e); //prints if there's any other kind of error
        }
    }
    public void stopAndPlaySound(String filePath2) {
        clip.stop();
        try{
            File musicPath = new File(filePath2);

            if(musicPath.exists()){
                Thread.sleep(1000);
                AudioInputStream audioInput2 = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput2);
                clip.start();
            }
            else {
                System.out.println("Can't find file");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
