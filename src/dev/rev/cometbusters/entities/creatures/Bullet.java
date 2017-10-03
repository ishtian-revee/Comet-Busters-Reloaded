package dev.rev.cometbusters.entities.creatures;

import java.awt.Graphics;

import dev.rev.cometbusters.Game;
import dev.rev.cometbusters.gfx.Assets;

public class Bullet {
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double radians;
	private double speed;
	
	public Bullet( double angle , float x , float y ){
		
		this.x = x;
		this.y = y;
		this.radians = Math.toRadians(angle);
		this.speed = 8;
		this.dx = Math.cos(radians) * speed;
		this.dy = Math.sin(radians) * speed;
	}
	
	public boolean tick(){
		
		x += dx;
		y += dy;
		
		if( x > Game.width || y > Game.height ){
			
			return true;
		}
		
		return false;
	}
	
	public void render(Graphics g){
		
		g.drawImage(Assets.laser , (int) x , (int) y , 9 , 29 , null);
	}
	
	// Getters
	
	public double getX(){
		
		return x;
	}
	
	public double getY(){
		
		return y;
	}
}
