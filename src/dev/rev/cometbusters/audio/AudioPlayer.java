package dev.rev.cometbusters.audio;

import javax.sound.sampled.*;

public class AudioPlayer {

	private int toneType;
	
	private Clip clip;
	
	public AudioPlayer( String s ){
		
		try{
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s));
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
					
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(),
					16,
					baseFormat.getChannels(),
					baseFormat.getChannels() * 2,
					baseFormat.getSampleRate(), 
					false
			);
			
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			
			clip = AudioSystem.getClip();
			clip.open(dais);
		}catch( Exception e ){
			
			e.printStackTrace();
		}
	}
	
	/*
	 * This method plays the sound or the music that has been passed as parameter
	 * 
	 * @param value			Integer value of the corresponding sound or music
	 * 
	 * Different types of audio 
	 * 1 = background music
	 * 2 = laser sound
	 * 3 = explosion sound
	 * 4 = power up sound
	 */
	public void play(int value){
		
		this.toneType = value;
		
		if( clip == null ){
			
			return;
		}
		
		stop();
		clip.setFramePosition(0);
		
		if( toneType == 1 ){
			
			// Setting the background music to play continuously
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}else if( toneType == 2 || toneType == 3 || toneType == 4 ){
			
			clip.start();
		}
	}
	
	/*
	 * This method stops the music
	 */
	public void stop(){
		
		if( clip.isRunning() ){
			
			clip.stop();
		}
	}
	
	public void close(){
		
		stop();
		clip.close();
	}

	// Getters and setters
	
	public Clip getClip() {
		
		return clip;
	}

	public void setClip(Clip clip) {
		
		this.clip = clip;
	}
}
