import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music {
	
	public static void playMusic(String filename)
	{
		InputStream music;
		try
		{
			music = new FileInputStream(new File(filename));
			AudioStream sound = new AudioStream(music);
			AudioPlayer.player.start(sound);
		}
		catch (Exception e)
		{
			System.out.println("Error");
		}
		
	}
	
	public static void stopMusic(String filename)
	{
		InputStream music;
		try
		{
			music = new FileInputStream(new File(filename));
			AudioStream sound = new AudioStream(music);
			AudioPlayer.player.stop(sound);
		}
		catch (Exception e)
		{
			System.out.println("Error");
		}
	}
}
