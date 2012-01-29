package twosnakes;

import sun.audio.*;
import java.io.*;

public class SoundEffectPlayer {
	
	private AudioStream as;
	
	public SoundEffectPlayer(String filename)
	{
		InputStream in;
		try {
			in = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			in = null;
		}
		try {
			as = new AudioStream(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void play()
	{
		AudioPlayer.player.start(as);
	}
	
	public void stop()
	{
		AudioPlayer.player.stop(as);
	}
	
}
