package dev.rev.cometbusters.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import dev.rev.cometbusters.Game;
import dev.rev.cometbusters.audio.AudioPlayer;
import dev.rev.cometbusters.entities.creatures.Bullet;
import dev.rev.cometbusters.entities.creatures.Comets;
import dev.rev.cometbusters.entities.creatures.Explosion;
import dev.rev.cometbusters.entities.creatures.MessageString;
import dev.rev.cometbusters.entities.creatures.Player;
import dev.rev.cometbusters.entities.creatures.PowerUp;
import dev.rev.cometbusters.gfx.Assets;

public class GameState extends State {
	
	private Player player;
	private Comets comet;
	
	public static ArrayList<Bullet> bullets;
	public static ArrayList<Comets> comets;
	public static ArrayList<PowerUp> powerUp;
	public static ArrayList<Explosion> explosions;
	public static ArrayList<MessageString> texts;
	
	// For levels
	private long levelStartTimer;
	private long levelStartTimerDiff;
	private int levelNumber;
	private boolean levelStart;
	private int levelDelay = 3000;
	
	// For slow down
	private long slowDownTimer;
	private long slowDownTimerDiff;
	private int slowDownLength = 7000;
	
	private String background = "/textures/background.png";
	
	public static boolean pauseScreen = false;
	
	private AudioPlayer explosionTone;
	private AudioPlayer powerUpTone;
	
	// Constructor
	public GameState(Game game){
		
		super(game);
		
		player = new Player(game , 290 , 830);
		
		bullets = new ArrayList<Bullet>();
		comets = new ArrayList<Comets>();
		powerUp = new ArrayList<PowerUp>();
		explosions = new ArrayList<Explosion>();
		texts = new ArrayList<MessageString>();
		
		levelStartTimer = 0;
		levelStartTimerDiff = 0;
		levelStart = true;
		levelNumber = 0;
		
		explosionTone = new AudioPlayer("/audio/explosion.mp3");
		powerUpTone = new AudioPlayer("/audio/powerup.mp3");
	}
	
	// Getter
	public Image getBackgroundImage(){
		
		ImageIcon icon = new ImageIcon(getClass().getResource(background));
		return icon.getImage();
	}
	
	@Override
	public void tick() {
		
		// For every new level
		if( levelStartTimer == 0 && comets.size() == 0 ){
			
			levelNumber++;
			levelStart = false;
			levelStartTimer = System.nanoTime();
		}else{
			
			levelStartTimerDiff = (System.nanoTime() - levelStartTimer) / 1000000;
			
			if( levelStartTimerDiff > levelDelay ){
				
				levelStart = true;
				levelStartTimer = 0;
				levelStartTimerDiff = 0;
			}
		}
		
		// Ticking player
		player.tick();
		
		// Creating comets
		if( levelStart && comets.size() == 0 ){
			
			if( levelNumber == 21 ){
				
				scores = player.getScore();
				State.setState(game.gameOverState);
			}
			
			createComets();
		}
		
		// Checking if pause or not
		if( pauseScreen ){
																	
			return;
		}
		
		// Ticking bullets
		for( int i=0; i<bullets.size(); i++ ){
			
			boolean remove = bullets.get(i).tick();
			
			if( remove ){
				
				bullets.remove(i);
				i--;
			}
		}
		
		// Ticking comets
		for( int i=0; i<comets.size(); i++ ){
			
			comets.get(i).tick();
		}
		
		// Ticking power ups 
		for( int i=0; i<powerUp.size(); i++ ){
			
			boolean remove = powerUp.get(i).tick();
			
			if( remove ){
				
				powerUp.remove(i);
				i--;
			}
		}
		
		// Ticking explosions
		for( int i=0; i<explosions.size(); i++ ){
			
			boolean remove = explosions.get(i).tick();
			
			if( remove ){
				
				explosions.remove(i);
				i--;
			}
		}
		
		// Ticking texts
		for( int i=0; i<texts.size(); i++ ){
			
			boolean remove = texts.get(i).tick();
			
			if( remove ){
				
				texts.remove(i);
				i--;
			}
		}
		
		// Collision Between Bullet and Comet
		for( int i=0; i<comets.size(); i++ ){
			
			Comets com = comets.get(i);
			
			double cX = com.getX();
			double cY = com.getY();
			
			for( int j=0; j<bullets.size(); j++ ){
				
				Bullet bul = bullets.get(j);
				
				double bX = bul.getX();
				double bY = bul.getY();
				
				if( comet.getType() == 1 || comet.getType() == 7 ){
					
					if( cX < bX + 5 && cX + 22 > bX && cY < bY + 5 && cY + 22 > bY ){
						
						com.hit();
						bullets.remove(j);
						j--;
					}
				}else if( comet.getType() == 2 || comet.getType() == 8 ){
					
					if( cX < bX + 5 && cX + 32 > bX && cY < bY + 5 && cY + 32 > bY ){
						
						com.hit();
						bullets.remove(j);
						j--;
					}
				}else if( comet.getType() == 3 || comet.getType() == 9 ){
					
					if( cX < bX + 5 && cX + 38 > bX && cY < bY + 5 && cY + 22 > bY ){
						
						com.hit();
						bullets.remove(j);
						j--;
					}
				}else if( comet.getType() == 4 || comet.getType() == 10 ){
					
					if( cX < bX + 5 && cX + 48 > bX && cY < bY + 5 && cY + 32 > bY ){
						
						com.hit();
						bullets.remove(j);
						j--;
					}
				}else if( comet.getType() == 5 || comet.getType() == 11 ){
					
					if( cX < bX + 5 && cX + 63 > bX && cY < bY + 5 && cY + 47 > bY ){
						
						com.hit();
						bullets.remove(j);
						j--;
					}
				}else if( comet.getType() == 6 || comet.getType() == 12 ){
					
					if( cX < bX + 5 && cX + 77 > bX && cY < bY + 5 && cY + 58 > bY ){
						
						com.hit();
						bullets.remove(j);
						j--;
					}
				}else if( comet.getType() == 13 || comet.getType() == 15 ){
					
					if( cX < bX + 5 && cX + 47 > bX && cY < bY + 5 && cY + 47 > bY ){
						
						com.hit();
						bullets.remove(j);
						j--;
					}
				}else if( comet.getType() == 14 || comet.getType() == 16 ){
					
					if( cX < bX + 5 && cX + 58 > bX && cY < bY + 5 && cY + 58 > bY ){
						
						com.hit();
						bullets.remove(j);
						j--;
					}
				}
			}
		}
		
		// Checking Destroyed Comets
		for( int i=0; i<comets.size(); i++ ){
			
			if( comets.get(i).isDestroyed() ){
				
				Comets c = comets.get(i);
				
				// Create power ups
				// 1 = health
				// 2 = power 
				// 3 = ship mode
				// 4 = score 10
				// 5 = score 50
				// 6 = score 100
				// 7 = slow down time
				double rand = Math.random();
				
				if( rand > 0 && rand <= 0.080 ){
					
					powerUp.add(new PowerUp(1 , c.getX() , c.getY()));
				}else if( rand >= 0.740 && rand <= 0.825 ){
					
					powerUp.add(new PowerUp(2 , c.getX() , c.getY()));
				}else if( rand >= 0.150 && rand <= 0.190 ){
					
					powerUp.add(new PowerUp(3 , c.getX() , c.getY()));
				}else if( (rand >= 0.220 && rand <= 0.260) || (rand >= 0.285 && rand <= 0.340) ){
					
					powerUp.add(new PowerUp(4 , c.getX() , c.getY()));
				}else if( (rand >= 0.385 && rand <= 0.415) || (rand >= 0.445 && rand <= 0.495) ){
					
					powerUp.add(new PowerUp(5 , c.getX() , c.getY()));
				}else if( rand >= 0.980 && rand < 1 ){
					
					powerUp.add(new PowerUp(6 , c.getX() , c.getY()));
				}else if( (rand >= 0.635 && rand <= 0.645) || (rand >= 0.660 && rand <= 0.690) ){
					
					powerUp.add(new PowerUp(7 , c.getX() , c.getY()));
				}
				
				player.addScore(c.getType() + c.getRank());
				comets.remove(i);
				i--;
				
				explosionTone.play(3);
				c.explode();
				
				if( c.getType() == 1 || c.getType() == 7 ){
					
					explosions.add(new Explosion(c.getX() , c.getY() , 10 , 40));
				}else if( c.getType() == 2 || c.getType() == 8 ){
					
					explosions.add(new Explosion(c.getX() , c.getY() , 20 , 50));
				}else if( c.getType() == 3 || c.getType() == 9 ){
					
					explosions.add(new Explosion(c.getX() , c.getY() , 30 , 60));
				}else if( c.getType() == 4 || c.getType() == 10 ){
					
					explosions.add(new Explosion(c.getX() , c.getY() , 40 , 70));
				}else if( c.getType() == 5 || c.getType() == 11 ){
					
					explosions.add(new Explosion(c.getX() , c.getY() , 50 , 80));
				}else if( c.getType() == 6 || c.getType() == 12 ){
					
					explosions.add(new Explosion(c.getX() , c.getY() , 60 , 90));
				}else if( c.getType() == 13 || c.getType() == 15 ){
					
					explosions.add(new Explosion(c.getX() , c.getY() , 47 , 77));
				}else if( c.getType() == 14 || c.getType() == 16 ){
					
					explosions.add(new Explosion(c.getX() , c.getY() , 58 , 88));
				}
			}
		}
		
		// Collision Between Player and Comet
		if( !player.isRecovering() ){
			
			float pX = player.getX();
			float pY = player.getY();
			
			for( int i=0; i<comets.size(); i++ ){
				
				Comets com = comets.get(i);
				
				double cX = com.getX();
				double cY = com.getY(); 
				
				if( comet.getType() == 1 || comet.getType() == 7 ){
					
					if( pX < cX + 22 && pX + 60 > cX && pY < cY + 26 && pY + 50 > cY ){
						
						player.loseLife();
						comets.remove(i);
						i--;
					}
				}else if( comet.getType() == 2 || comet.getType() == 8 ){
					
					if( pX < cX + 32 && pX + 60 > cX && pY < cY + 36 && pY + 50 > cY ){
						
						player.loseLife();
						comets.remove(i);
						i--;
					}
				}else if( comet.getType() == 3 || comet.getType() == 9 ){
					
					if( pX < cX + 38 && pX + 60 > cX && pY < cY + 34 && pY + 50 > cY ){
						
						player.loseLife();
						comets.remove(i);
						i--;
					}
				}else if( comet.getType() == 4 || comet.getType() == 10 ){
					
					if( pX < cX + 48 && pX + 60 > cX && pY < cY + 44 && pY + 50 > cY ){
						
						player.loseLife();
						comets.remove(i);
						i--;
					}
				}else if( comet.getType() == 5 || comet.getType() == 11 ){
					
					if( pX < cX + 50 && pX + 60 > cX && pY < cY + 56 && pY + 50 > cY ){
						
						player.loseLife();
						comets.remove(i);
						i--;
					}
				}else if( comet.getType() == 6 || comet.getType() == 12 ){
					
					if( pX < cX + 50 && pX + 70 > cX && pY < cY + 66 && pY + 50 > cY ){
						
						player.loseLife();
						comets.remove(i);
						i--;
					}
				}else if( comet.getType() == 13 || comet.getType() == 15 ){
					
					if( pX < cX + 50 && pX + 47 > cX && pY < cY + 51 && pY + 50 > cY ){
						
						player.loseLife();
						comets.remove(i);
						i--;
					}
				}else if( comet.getType() == 14 || comet.getType() == 16 ){
					
					if( pX < cX + 50 && pX + 58 > cX && pY < cY + 62 && pY + 50 > cY ){
						
						player.loseLife();
						comets.remove(i);
						i--;
					}
				}
			}
		}
		
		// Checking if the player is dead
		if( player.isDead() ){
			
			scores = player.getScore();
			State.setState(game.gameOverState);
		}
		
		// Collision between player and power ups
		float pX = player.getX();
		float pY = player.getY();
		
		for( int i=0; i<powerUp.size(); i++ ){
			
			PowerUp p = powerUp.get(i);
			
			double puX = p.getX();
			double puY = p.getY();
			
			if( pX < puX + 20 && pX + 60 > puX && pY < puY + 20 && pY + 50 > puY ){
				
				int type = p.getType();
				
				if( type == 1 ){
					
					player.gainLife();
					texts.add(new MessageString(player.getX() + 10 , player.getY() - 10, 1000 , "+Life"));
				}else if( type == 2 ){
					
					player.increasePower();
					texts.add(new MessageString(player.getX() + 3 , player.getY() - 10, 1000 , "+Power"));
				}else if( type == 3 ){
					
					player.increaseShipLevel();
					texts.add(new MessageString(player.getX() - 15 , player.getY() - 10, 1000 , "+Ship Level"));
				}else if( type == 4 ){
					
					player.increaseScore(10);
					texts.add(new MessageString(player.getX() + 5, player.getY() - 10, 1000 , "+10XP"));
				}else if( type == 5 ){
					
					player.increaseScore(50);
					texts.add(new MessageString(player.getX() + 5, player.getY() - 10, 1000 , "+50XP"));
				}else if( type == 6 ){
					
					player.increaseScore(100);
					texts.add(new MessageString(player.getX() + 5 , player.getY() - 10, 1000 , "+100XP"));
				}else if( type == 7 ){
					
					slowDownTimer = System.nanoTime();
					
					for( int j=0; j<comets.size(); j++ ){
						
						comets.get(j).setSlow(true);
					}
					
					texts.add(new MessageString(player.getX() - 10, player.getY() - 10, 1000 , "Slow Down"));
				}
				
				powerUpTone.play(4);
				powerUp.remove(i);
				i--;
			}
		}
		
		// Slow down update
		if( slowDownTimer != 0 ){
			
			slowDownTimerDiff = (System.nanoTime() - slowDownTimer) / 1000000;
			
			if( slowDownTimerDiff > slowDownLength ){
				
				slowDownTimer = 0;
				
				for( int j=0; j<comets.size(); j++ ){
					
					comets.get(j).setSlow(false);
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
		// Rendering background
		g.drawImage(getBackgroundImage(), 0, 0, null);
		
		// Rendering player
		player.render(g);
		
		// Rendering bullets
		for( int i=0; i<bullets.size(); i++ ){
			
			bullets.get(i).render(g);
		}
		
		// Rendering comets
		for( int i=0; i<comets.size(); i++ ){
			
			comets.get(i).render(g);
		}
		
		// Rendering power ups
		for( int i=0; i<powerUp.size(); i++ ){
			
			powerUp.get(i).render(g);
		}
		
		// Rendering explosions
		for( int i=0; i<explosions.size(); i++ ){
			
			explosions.get(i).render(g);
		}
		
		// Rendering texts
		for( int i=0; i<texts.size(); i++ ){
			
			texts.get(i).render(g);
		}
		
		// Rendering level number
		if( levelStartTimer != 0 ){
			
			int trans = (int) (255 * Math.sin(3.14 * levelStartTimerDiff / levelDelay));
			
			if( trans > 255 ){
				
				trans = 255;
			}
			
			if( levelNumber == 21 ){
				
				g.setColor(new Color(255 , 255 , 255 , trans));
				g.setFont(new Font("Century Gothic" , Font.PLAIN , 55));
				String s = "CONGRATULATIONS";
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
				g.drawString(s, Game.width / 2 - length / 2, Game.height / 2 - 30);
				
				g.setColor(new Color(255 , 255 , 255 , trans));
				g.setFont(new Font("Century Gothic" , Font.PLAIN , 30));
				s = "YOU FINISHED THE GAME";
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
				g.drawString(s, Game.width / 2 - length / 2, Game.height / 2 + 20);
			}else{
				
				g.setColor(new Color(255 , 255 , 255 , trans));
				g.setFont(new Font("Century Gothic" , Font.PLAIN , 50));
				String s = "L E V E L " + levelNumber;
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
				g.drawString(s, Game.width / 2 - length / 2, Game.height / 2);
			}
		}
		
		// Rendering player lives
		for( int i=0; i<player.getLives(); i++ ){
			
			g.drawImage(Assets.lives , 20 + (40 * i) , 20 , 30 , 30 , null);
		}
		
		// Rendering player powers
		for( int i=0; i<player.getPower(); i++ ){
			
			g.drawImage(Assets.power , 20 + (30 * i) , 60 , 19 , 30 , null);
		}
		
		// Rendering score
		g.setColor(Color.white);
		g.setFont(new Font("Century Gothic" , Font.PLAIN , 20));
		g.drawString("Score : " + player.getScore(), Game.width - 150, 40);
		
		// Rendering ship levels
		for( int i=0; i<player.getShipLevel(); i++ ){
			
			g.drawImage(Assets.shipMode , 520 + (35 * i) , 50 , 30 , 30 , null);
		}
		
		// Rendering slow down meter
		if( slowDownTimer != 0 ){
			
			g.setColor(Color.WHITE);
			g.drawRect(20, 100, 100, 8);
			g.fillRect(20, 100, (int)(100 - (100.0 * slowDownTimerDiff) / slowDownLength), 8);
		}
		
		// Rendering slow down screen
		if( slowDownTimer != 0 ){
			
			g.setColor(new Color(255 , 255 , 255 , 40));
			g.fillRect(0, 0, Game.width, Game.height);
		}
		
		// Checking if pause or not
		if( pauseScreen ){
									
			g.setColor(new Color(255 , 255 , 255 , 40));
			g.fillRect(0, 0, Game.width, Game.height);
									
			g.setFont(new Font("Agency FB" , Font.PLAIN , 65));
			String s = "GAME PAUSED";
			int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			g.setColor(Color.WHITE);
			g.drawString(s, Game.width / 2 - length / 2, Game.height / 2);
			
			g.setFont(new Font("Agency FB" , Font.PLAIN , 25));
			s = "PRESS 'ESC' TO CONTINUE";
			length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			g.setColor(Color.WHITE);
			g.drawString(s, Game.width / 2 - length / 2, Game.height / 2 + 300);
									
			return;
		}
	}
	
	/*
	 * Comets creations for each levels
	 */
	public void createComets(){
		
		comets.clear();
		
		// Level design
		if( levelNumber == 1 ){				// level 1
			
			comet = new Comets(1 , 1);
			
			for( int i=0; i<5; i++ ){
				
				comets.add(new Comets(1 , 1));
			}
			
			for( int i=0; i<5; i++ ){
				
				comets.add(new Comets(7 , 1));
			}
		}else if( levelNumber == 2 ){		// level 2
			
			comet = new Comets(1 , 2);
			
			for( int i=0; i<6; i++ ){
				
				comets.add(new Comets(1 , 2));
			}
			
			for( int i=0; i<6; i++ ){
				
				comets.add(new Comets(7 , 2));
			}
		}else if( levelNumber == 3 ){		// level 3
			
			comet = new Comets(1 , 1);
			
			for( int i=0; i<4; i++ ){
				
				comets.add(new Comets(1 , 1));
			}
						
			for( int i=0; i<3; i++ ){
				
				comets.add(new Comets(1 , 2));
			}
			
			for( int i=0; i<4; i++ ){
				
				comets.add(new Comets(7 , 1));
			}
						
			for( int i=0; i<3; i++ ){
				
				comets.add(new Comets(7 , 2));
			}
		}else if( levelNumber == 4 ){		// level 4
			
			comet = new Comets(2 , 1);
			
			for( int i=0; i<5; i++ ){
				
				comets.add(new Comets(2 , 1));
			}
						
			for( int i=0; i<5; i++ ){
				
				comets.add(new Comets(8 , 1));
			}
		}else if( levelNumber == 5 ){		// level 5
			
			comet = new Comets(2 , 1);
			
			for( int i=0; i<3; i++ ){
				
				comets.add(new Comets(2 , 1));
			}
						
			for( int i=0; i<4; i++ ){
				
				comets.add(new Comets(2 , 2));
			}
			
			for( int i=0; i<3; i++ ){
				
				comets.add(new Comets(8 , 1));
			}
						
			for( int i=0; i<4; i++ ){
				
				comets.add(new Comets(8 , 2));
			}
		}else if( levelNumber == 6 ){		// level 6
			
			comet = new Comets(2 , 1);
			
			comets.add(new Comets(1 , 1));
			comets.add(new Comets(1 , 1));
			comets.add(new Comets(1 , 2));
			comets.add(new Comets(1 , 2));
			comets.add(new Comets(2 , 1));
			comets.add(new Comets(2 , 1));
			comets.add(new Comets(2 , 2));
			comets.add(new Comets(2 , 2));
			comets.add(new Comets(7 , 1));
			comets.add(new Comets(7 , 1));
			comets.add(new Comets(7 , 2));
			comets.add(new Comets(7 , 2));
			comets.add(new Comets(8 , 1));
			comets.add(new Comets(8 , 1));
			comets.add(new Comets(8 , 2));
			comets.add(new Comets(8 , 2));
		}else if( levelNumber == 7 ){		// level 7
			
			comet = new Comets(3 , 1);
			
			for( int i=0; i<4; i++ ){
				
				comets.add(new Comets(3 , 1));
			}
			
			for( int i=0; i<4; i++ ){
				
				comets.add(new Comets(9 , 1));
			}
		}else if( levelNumber == 8 ){		// level 8
			
			comet = new Comets(3 , 1);
			
			comets.add(new Comets(3 , 1));
			comets.add(new Comets(3 , 2));
			comets.add(new Comets(3 , 2));
			comets.add(new Comets(3 , 2));
			comets.add(new Comets(9 , 1));
			comets.add(new Comets(9 , 2));
			comets.add(new Comets(9 , 2));
			comets.add(new Comets(9 , 2));
		}else if( levelNumber == 9 ){		// level 9
			
			comet = new Comets(3 , 1);
			
			comets.add(new Comets(3 , 1));
			comets.add(new Comets(3 , 1));
			comets.add(new Comets(3 , 2));
			comets.add(new Comets(3 , 2));
			comets.add(new Comets(3 , 2));
			comets.add(new Comets(9 , 1));
			comets.add(new Comets(9 , 1));
			comets.add(new Comets(9 , 2));
			comets.add(new Comets(9 , 2));
			comets.add(new Comets(9 , 2));
		}else if( levelNumber == 10 ){		// level 10
			
			comet = new Comets(3 , 1);
			
			comets.add(new Comets(3 , 1));
			comets.add(new Comets(3 , 1));
			comets.add(new Comets(3 , 2));
			comets.add(new Comets(3 , 2));
			comets.add(new Comets(9 , 1));
			comets.add(new Comets(9 , 1));
			comets.add(new Comets(9 , 2));
			comets.add(new Comets(9 , 2));
			comets.add(new Comets(1 , 1));
			comets.add(new Comets(1 , 1));
			comets.add(new Comets(1 , 2));
			comets.add(new Comets(1 , 2));
			comets.add(new Comets(7 , 1));
			comets.add(new Comets(7 , 1));
			comets.add(new Comets(7 , 2));
			comets.add(new Comets(7 , 2));
		}else if( levelNumber == 11 ){		// level 11
			
			comet = new Comets(5 , 1);
			
			for( int i=0; i<3; i++ ){
				
				comets.add(new Comets(5 , 1));
			}
						
			for( int i=0; i<3; i++ ){
				
				comets.add(new Comets(11 , 1));
			}
		}else if( levelNumber == 12 ){		// level 12
			
			comet = new Comets(5 , 1);
			
			for( int i=0; i<3; i++ ){
				
				comets.add(new Comets(5 , 2));
			}
						
			for( int i=0; i<3; i++ ){
				
				comets.add(new Comets(11 , 2));
			}
		}else if( levelNumber == 13 ){		// level 13
			
			comet = new Comets(5 , 1);
			
			comets.add(new Comets(5 , 1));
			comets.add(new Comets(5 , 1));
			comets.add(new Comets(5 , 2));
			comets.add(new Comets(5 , 2));
			comets.add(new Comets(11 , 1));
			comets.add(new Comets(11 , 1));
			comets.add(new Comets(11 , 2));
		}else if( levelNumber == 14 ){		// level 14
			
			comet = new Comets(6 , 1);
			
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(6 , 2));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(12 , 2));
		}else if( levelNumber == 15 ){		// level 15
			
			comet = new Comets(5 , 1);
			
			comets.add(new Comets(5 , 1));
			comets.add(new Comets(5 , 1));
			comets.add(new Comets(5 , 2));
			comets.add(new Comets(11 , 1));
			comets.add(new Comets(11 , 1));
			comets.add(new Comets(11 , 2));
			comets.add(new Comets(13 , 1));
			comets.add(new Comets(13 , 1));
			comets.add(new Comets(13 , 2));
			comets.add(new Comets(13 , 2));
			comets.add(new Comets(15 , 1));
			comets.add(new Comets(15 , 1));
			comets.add(new Comets(15 , 2));
			comets.add(new Comets(15 , 2));
		}else if( levelNumber == 16 ){		// level 16
			
			comet = new Comets(6 , 1);
			
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(6 , 2));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(12 , 2));
			comets.add(new Comets(14 , 1));
			comets.add(new Comets(14 , 1));
			comets.add(new Comets(14 , 2));
			comets.add(new Comets(14 , 2));
			comets.add(new Comets(16 , 1));
			comets.add(new Comets(16 , 1));
			comets.add(new Comets(16 , 2));
			comets.add(new Comets(16 , 2));
		}else if( levelNumber == 17 ){		// level 17
			
			comet = new Comets(6 , 1);
			
			comets.add(new Comets(5 , 1));
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(5 , 2));
			comets.add(new Comets(11 , 1));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(11 , 2));
		}else if( levelNumber == 18 ){		// level 18
			
			comet = new Comets(6 , 1);
			
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(5 , 2));
			comets.add(new Comets(6 , 2));
			comets.add(new Comets(6 , 2));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(11 , 2));
			comets.add(new Comets(12 , 2));
			comets.add(new Comets(12 , 2));
		}else if( levelNumber == 19 ){		// level 19
			
			comet = new Comets(6 , 1);
			
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(6 , 2));
			comets.add(new Comets(6 , 2));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(12 , 2));
			comets.add(new Comets(12 , 2));
			comets.add(new Comets(14 , 2));
			comets.add(new Comets(16 , 2));
		}else if( levelNumber == 20 ){		// level 20
			
			comet = new Comets(6 , 1);
			
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(6 , 1));
			comets.add(new Comets(6 , 2));
			comets.add(new Comets(6 , 2));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(12 , 1));
			comets.add(new Comets(12 , 2));
			comets.add(new Comets(12 , 2));
			comets.add(new Comets(14 , 1));
			comets.add(new Comets(14 , 2));
			comets.add(new Comets(14 , 2));
			comets.add(new Comets(16 , 1));
			comets.add(new Comets(16 , 2));
			comets.add(new Comets(16 , 2));
		}
	}
}
