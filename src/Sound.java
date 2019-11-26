import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Sound {
	
	public static void playAudio(String filename){

	InputStream in = null;
	AudioStream as = null;

	try{
	in = new FileInputStream(filename);
	}

	catch(FileNotFoundException fnfe){
	System.out.println("File not found");
	}

	try{
	as = new AudioStream(in);
	}

	catch(IOException ie){

	System.out.println("Error");
	}

	AudioPlayer.player.start(as);
	}

}
