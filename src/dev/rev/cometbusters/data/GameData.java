package dev.rev.cometbusters.data;

import java.io.Serializable;

public class GameData implements Serializable {

	private static final long serialVersionUID = 1;
	
	private final int MAX_SCORES = 10;
	private long [] highScores;
	private String [] names;
	private long tempScore;
	
	public GameData(){
		
		highScores = new long [MAX_SCORES];
		names = new String [MAX_SCORES];
	}
	
	public void init(){
		
		for( int i=0; i<MAX_SCORES; i++ ){
			
			highScores[i] = 0;
			names[i] = "- - -";
		}
	}
	
	/*
	 * This method checks if the passed score is higher 
	 * than the previous high score or not
	 * 
	 * @param score		New score
	 * 
	 * @return true		If the new score is higher than previous high score
	 */
	public boolean isHighScore( long score ){
		
		return score > highScores[MAX_SCORES - 1];
	}
	
	/*
	 * This method add the passed score as high score
	 * 
	 * @param newScore		New score
	 * @param name			User name
	 */
	public void addHighScore( long newScore , String name ){
		
		if( isHighScore(newScore) ){
			
			highScores[MAX_SCORES - 1] = newScore;
			names[MAX_SCORES - 1] = name;
			sortHighScores();
		}
	}
	
	/*
	 * This method applies selection sort algorithm to 
	 * sort out the high scores
	 */
	public void sortHighScores(){
		
		for( int i=0; i<MAX_SCORES; i++ ){
			
			long score = highScores[i];
			String name = names[i];
			int j;
			
			for( j=i-1; j>=0 && highScores[j] < score; j-- ){
				
				highScores[j+1] = highScores[j];
				names[j+1] = names[j];
			}
			
			highScores[j+1] = score;
			names[j+1] = name;
		}
	}
	
	// Getters and setters
	
	public long [] getHighScores(){
		
		return highScores;
	}
	
	public String [] getNames(){
		
		return names;
	}
	
	public long getTempScore(){
		
		return tempScore;
	}
	
	public void setTempScore( long score ){
		
		tempScore = score;
	}
}
