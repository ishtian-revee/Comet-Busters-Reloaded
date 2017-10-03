package dev.rev.cometbusters.entities.creatures;

import java.awt.Graphics;

import dev.rev.cometbusters.Game;
import dev.rev.cometbusters.gfx.Assets;

public class PowerUp {

	private double x;
	private double y;
	
	private int type;
	
	// Power up types
	// 1 = health
	// 2 = power 
	// 3 = ship mode
	// 4 = score 10
	// 5 = score 50
	// 6 = score 100
	// 7 = slow down time
	
	// Constructor
	public PowerUp( int type , double x , double y ){
		
		this.type = type;
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Power up updates
	 */
	public boolean tick(){
		
		y += 2;
		
		if( y > Game.height ){
			
			return true;
		}
		
		return false;
	}
	
	/*
	 * Drawing power ups
	 */
	public void render(Graphics g){
		
		if( type == 1 ){
			
			g.drawImage(Assets.health , (int) x , (int) y , 20 , 20 , null);
		}
		
		if( type == 2 ){
			
			g.drawImage(Assets.powerUp , (int) x , (int) y , 20 , 20 , null);
		}
		
		if( type == 3 ){
			
			g.drawImage(Assets.modes , (int) x , (int) y , 20 , 20 , null);
		}
		
		if( type == 4 ){
			
			g.drawImage(Assets.scoreTen , (int) x , (int) y , 20 , 20 , null);
		}
		
		if( type == 5 ){
			
			g.drawImage(Assets.scoreFifty , (int) x , (int) y , 20 , 20 , null);
		}
		
		if( type == 6 ){
			
			g.drawImage(Assets.scoreHundred , (int) x , (int) y , 20 , 20 , null);
		}
		
		if( type == 7 ){
			
			g.drawImage(Assets.slowDownPill , (int) x , (int) y , 20 , 20 , null);
		}
	}
	
	// Getters
	
	public int getType(){
		
		return type;
	}
	
	public double getX(){
		
		return x;
	}
	
	public double getY(){
		
		return y;
	}
}
