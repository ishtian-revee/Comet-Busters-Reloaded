package dev.rev.cometbusters.entities.creatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MessageString {

	private double x;
	private double y;
	private long time;
	private long start;
	private String text;
	
	// Constructor
	public MessageString( double x , double y , long time , String text ){
		
		this.x = x;
		this.y = y;
		this.time = time;
		this.text = text;
		start = System.nanoTime();
	}
	
	/*
	 * Calculates elapsed time for displaying the message strings
	 */
	public boolean tick(){
		
		long elapsed = (System.nanoTime() - start) / 1000000;
		
		if( elapsed > time ){
			
			return true;
		}
		
		return false;
	}
	
	/*
	 * Draw the message strings in specific x and y coordinate
	 */
	public void render(Graphics g){
		
		g.setColor(new Color(200, 95, 105));
		g.setFont(new Font("Century Gothic", Font.BOLD, 15));
		g.drawString(text , (int) x , (int) y);
	}
}
