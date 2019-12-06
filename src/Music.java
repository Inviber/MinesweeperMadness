import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music {
	
	static InputStream music = null;
	static AudioStream audio = null;
	
	public static void getMusicFile(String filename)
	{
		try
		{
			music = new FileInputStream(new File(filename));
			audio = new AudioStream(music);
			
		}
		catch (Exception e)
		{
			System.out.println("Error");
		}
	}
	
	
	public static void play()
	{
		
		AudioPlayer.player.start(audio);
	}
	
	public static void stop()
	{
		AudioPlayer.player.stop(audio);
	}
}
