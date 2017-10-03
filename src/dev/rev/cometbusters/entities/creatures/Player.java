package dev.rev.cometbusters.entities.creatures;

import java.awt.Graphics;

import dev.rev.cometbusters.Game;
import dev.rev.cometbusters.audio.AudioPlayer;
import dev.rev.cometbusters.gfx.Assets;
import dev.rev.cometbusters.states.GameState;

public class Player extends Creatures {
	
	private Game game;
	
	private int lives;
	private boolean dead = false;
	
	private boolean firing;
	private long firingTimer;
	private long firingDelay;
	
	private boolean recovering;
	private long recoveryTimer;
	
	private long score = 0;
	
	private boolean hited;
	private int shipLevel;
	private int power;
	
	private AudioPlayer laserTone;

	// Constructor
	public Player( Game game , float x, float y ) {
		
		super(60 , 50);
		this.game = game;
		this.x = x;
		this.y = y;
		this.firing = false;
		this.hited = false;
		this.lives = 3;
		this.power = 0;
		this.shipLevel = 0;
		this.firingTimer = System.nanoTime();
		this.firingDelay = 200;
		this.recovering = false;
		this.recoveryTimer = 0;
		
		laserTone = new AudioPlayer("/audio/laser.mp3"); 
	}

	/*
	 * (non-Javadoc)
	 * @see dev.rev.cometbusters.entities.creatures.Creatures#tick()
	 * 
	 * Deals with each and every calculations related to the player
	 * and update them in every frame
	 */
	public void tick() {
		
		getInput();
		move();
		
		if(firing){
			
			long elapsed = (System.nanoTime() - firingTimer) / 1000000;
			
			if( elapsed > firingDelay ){
				
				firingTimer = System.nanoTime();
				
				if(power >=0 && power < 3){
					
					GameState.bullets.add(new Bullet(270.00 , (x + 25)  , (y - height/2 + 10)));
				}else if( power >= 3 && power < 5 ){
					
					GameState.bullets.add(new Bullet(270.00 , (x + 13)  , (y - height/2 + 10)));
					GameState.bullets.add(new Bullet(270.00 , (x + 38)  , (y - height/2 + 10)));
				}else if( power >= 5 ){
					
					GameState.bullets.add(new Bullet(270.00 , (x + 4)  , (y - height/2 + 10)));
					GameState.bullets.add(new Bullet(270.00 , (x + 25)  , (y - height/2 + 10)));
					GameState.bullets.add(new Bullet(270.00 , (x + 46)  , (y - height/2 + 10)));
				}
				
				laserTone.play(2);
			}
		}
		
		firing = false;
		
		long elapsed = (System.nanoTime() - recoveryTimer) / 1000000;
		
		if( elapsed > 2000 ){
			
			recovering = false;
			recoveryTimer = 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see dev.rev.cometbusters.entities.creatures.Creatures#render(java.awt.Graphics)
	 * 
	 * Draw the player in each frames
	 */
	public void render(Graphics g) {
		
		if( shipLevel >=0 && shipLevel < 2 ){
			
			g.drawImage(Assets.player1 , (int) x , (int) y , width , height , null);
		}else if( shipLevel >=2 && shipLevel < 3 ){
			
			g.drawImage(Assets.player2 , (int) x , (int) y , width , height , null);
		}else if( shipLevel >= 3 ){
			
			g.drawImage(Assets.player3 , (int) x , (int) y , width , height , null);
		}
	}
	
	/*
	 * This method deals with inputs for the players
	 */
	public void getInput(){
		
		xMove = 0;
		yMove = 0;
		
		if( game.getKeyManager().pause ){
			
			GameState.pauseScreen = !GameState.pauseScreen;
			return;
		}
		
		if( game.getKeyManager().up || game.getKeyManager().upArrow ){
			
			if(GameState.pauseScreen){
				
				return;
			}
			
			yMove = -speed;
		}
		
		if( game.getKeyManager().down || game.getKeyManager().downArrow ){
			
			if(GameState.pauseScreen){
				
				return;
			}
			
			yMove = speed;
		}

		if( game.getKeyManager().left || game.getKeyManager().leftArrow ){
	
			if(GameState.pauseScreen){
				
				return;
			}
			
			xMove = -speed;
		}

		if( game.getKeyManager().right || game.getKeyManager().rightArrow ){
	
			if(GameState.pauseScreen){
				
				return;
			}
			
			xMove = speed;
		}
		
		if( game.getKeyManager().shoot ){
			
			if(GameState.pauseScreen){
				
				setFiring(false);
				return;
			}
			
			setFiring(true);
		}
	}
	
	/*
	 * This method increases player life when the player 
	 * gets the life power up
	 */
	public void gainLife(){
		
		lives++;
		
		if( shipLevel < 1 ){
			
			if( lives >= 3 ){
				
				lives = 3;
			}
		}else if( shipLevel >=1 && shipLevel < 3 ){
			
			if( lives >= 4 ){
				
				lives = 4;
			}
		}else if( shipLevel >= 3 ){
			
			if( lives >= 5 ){
				
				lives = 5;
			}
		}
	}
	
	/*
	 * This method increases laser power 
	 */
	public void increasePower(){
		
		power ++;
		
		if( power >= 5 ){
			
			power = 5;
		}
	}
	
	/*
	 * This method decreases player life if it destroyed
	 */
	public void loseLife(){
		
		lives--;
		
		if( lives <= 0 ){
			
			dead = true;
		}
		
		recovering = true;
		recoveryTimer = System.nanoTime();
		
		hited = true;
		
		if(hited){
			
			power = 0;
			shipLevel = 0;
			hited = false;
		}
	}
	
	/*
	 * This method increases player ship levels
	 */
	public void increaseShipLevel(){
		
		shipLevel++;
		
		if( shipLevel >= 3 ){
			
			shipLevel = 3;
		}
		
		hited = true;
	}
	
	/*
	 * Increases scores
	 */
	public void increaseScore(int point){
		
		score += point;
	}
	
	/*
	 * Add scores
	 */
	public void addScore( int i ){
		
		score += i;
	}
	
	// Getters and setters
	
	public void setDead(boolean dead){
		
		this.dead = dead;
	}
	
	public boolean isDead(){
		
		return dead;
	}
	
	public int getLives(){
		
		return lives;
	}
	
	public int getPower(){
		
		return power;
	}
	
	public boolean isRecovering(){
		
		return recovering;
	}
	
	public void setFiring(boolean b){
		
		firing = b;
	}
	
	public long getScore(){
		
		return score;
	}
	
	public int getShipLevel(){
		
		return shipLevel;
	}
		
	public float getX() {
		
		return x;
	}

	public void setX(float x) {
			
		this.x = x;
	}

	public float getY() {
			
		return y;
	}

	public void setY(float y) {
			
		this.y = y;
	}
}
