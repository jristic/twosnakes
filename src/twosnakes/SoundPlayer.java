package twosnakes;

import java.awt.event.ActionListener;
import java.io.*;
import sun.audio.*;


public class SoundPlayer implements Sound
{
	private AudioStream audioStream;
	private ContinuousAudioDataStream cas;
	private boolean looping;
	
	public SoundPlayer(String filename)
	{
		setSound(filename);
		this.looping = false;
	}
	
	public SoundPlayer(String filename, boolean looping)
	{
		setSound(filename);
		this.looping = looping; 
	}
	
	public void playSound()
	{
		if (audioStream != null)
		{
			if (looping)
			{
				AudioPlayer.player.start(cas);
			}
			else
			{
				AudioPlayer.player.start(audioStream);
			}
		}
	}
	
	public void stopSound()
	{
		if (audioStream != null)
		{
			if (looping)
			{
				AudioPlayer.player.stop(cas);
			}
			else
			{
				AudioPlayer.player.stop(audioStream);
			}
		}
	}
	
	public void setLooping(boolean looping)
	{
		this.looping = looping;
	}
	
	public void setSound(String filename)
	{
		InputStream in;
		InputStream in2;
		try {
			in = new FileInputStream(filename);
			in2 = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			in = null;
			in2 = null;
		}
		try {
			audioStream = new AudioStream(in);
			AudioStream audioStreamClone = new AudioStream(in2);
			AudioData data = audioStreamClone.getData();
			cas = new ContinuousAudioDataStream(data);
		} catch (IOException e) {
			e.printStackTrace();
			audioStream = null;
			cas = null;
		}
	}
	
	public void makeSound(ActionListener al)
	{
		
	}
	
	
	public static void main(String args[])
	{
		SoundPlayer soundPlayer = new SoundPlayer("testsound.wav", false);
		//soundPlayer.setSound("store_paging.wav");
		soundPlayer.setLooping(true);
		soundPlayer.playSound();
	}
	
}
