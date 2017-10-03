package dev.rev.cometbusters.entities.creatures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Explosion {
	
	private double x;
	private double y;
	private int radius;
	private int maxRadius;
	
	// Constructor
	public Explosion(double x , double y , int radius , int maxRadius ){
		
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.maxRadius = maxRadius;
	}
	
	/*
	 * Ticks and update radius calculation for each 
	 * explosion in all frames
	 */
	public boolean tick(){
		
		radius += 2;
		
		if( radius >= maxRadius ){
			
			return true;
		}
		
		return false;
	}
	
	/*
	 * Renders or draw the explosions
	 */
	public void render(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(new Color(255 , 255 , 255 , 128));
		g2.setStroke(new BasicStroke(3));		
		g2.drawOval((int) (x - radius + 10) , (int) (y - radius + 10) , 2 * radius , 2 * radius);
		g2.setStroke(new BasicStroke(1));
	}
}
