package dev.rev.cometbusters.entities.creatures;

import java.awt.Graphics;

import dev.rev.cometbusters.Game;

public abstract class Creatures {
	
	public static final float DEFAULT_SPEED = 3.0f;
	
	protected float x;
	protected float y;
	protected int width;
	protected int height;
	
	protected float speed;
	protected float xMove;
	protected float yMove;
	
	// Constructor
	public Creatures( int width , int height ){
		
		this.width = width;
		this.height = height;
		this.speed = DEFAULT_SPEED;
		this.xMove = 0;
		this.yMove = 0;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	/*
	 * Deals with the movement of each creature objects
	 * such as player, comets and power ups
	 */
	public void move(){
		
		if( x <= 0 ){
			
			x = 0;
		}else if( y < 0){
		
			y = 0;
		}else if( (x + 60) >= Game.width ){
			
			x = Game.width - 60;
		}else if( (y + 50) >= Game.height ){
			
			y = Game.height - 50;
		}
		
		x += xMove;
		y += yMove;
	}
	
	// Getters and Setters

	public float getxMove() {
		
		return xMove;
	}

	public void setxMove(float xMove) {
		
		this.xMove = xMove;
	}

	public float getYmove() {
		
		return yMove;
	}

	public void setYmove(float yMove) {
		
		this.yMove = yMove;
	}

	public float getSpeed() {
		
		return speed;
	}

	public void setSpeed(float speed) {
		
		this.speed = speed;
	}

	public int getWidth() {
		
		return width;
	}

	public int getHeight() {
		
		return height;
	}
}
