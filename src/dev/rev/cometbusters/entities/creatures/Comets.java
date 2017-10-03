package dev.rev.cometbusters.entities.creatures;

import java.awt.Graphics;

import dev.rev.cometbusters.Game;
import dev.rev.cometbusters.gfx.Assets;
import dev.rev.cometbusters.states.GameState;

public class Comets {
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	private double radians;
	private double speed;
	
	private int health;
	private int type;
	private int rank;
	private boolean ready;
	private boolean destroyed;
	private int amount = 0;
	
	public static boolean exploded = false;
	
	private boolean slow;
	
	// Constructor
	public Comets( int type , int rank ){
		
		this.type = type;
		this.rank = rank;
		
		cometTypes();
		
		this.x = Math.random() * Game.width/2 + Game.width/4;
		this.y = -50;
		
		double angle = Math.random() * 130 + 2;
		this.radians = Math.toRadians(angle);
		
		this.dx = Math.cos(radians) * speed;
		this.dy = Math.sin(radians) * speed;
		
		this.ready = false;
		this.destroyed = false;
	}
	
	/*
	 * This method ticks or update every calculation 
	 * related to the comets
	 */
	public void tick(){
		
		// If player gets slow down pill
		if( slow ){
			
			x += dx * 0.3;
			y += dy * 0.3;
		}else{
			
			x += dx;
			y += dy;
		}
		
		if( !ready ){
			
			if( x < Game.width && y < Game.height ){
				
				ready = true;
			}
		}
		
		if( x < 0 && dx < 0 ){
			
			dx = -dx;
		}
		
		if( y < 0 && dy < 0 ){
			
			dy = -dy;
		}
		
		if( type == 1 || type == 7 ){
			
			if( x > (Game.width - 22) && dx > 0 ){
				
				dx = -dx;
			}
			
			if( y > (Game.height - 22) && dy > 0 ){
				
				dy = -dy;
			}
		}else if( type == 2 || type == 8 ){
			
			if( x > (Game.width - 32) && dx > 0 ){
				
				dx = -dx;
			}
			
			if( y > (Game.height - 32) && dy > 0 ){
				
				dy = -dy;
			}
		}else if( type == 3 || type == 9 ){
			
			if( x > (Game.width - 38) && dx > 0 ){
				
				dx = -dx;
			}
			
			if( y > (Game.height - 38) && dy > 0 ){
				
				dy = -dy;
			}
		}else if( type == 4 || type == 10 ){
			
			if( x > (Game.width - 48) && dx > 0 ){
				
				dx = -dx;
			}
			
			if( y > (Game.height - 48) && dy > 0 ){
				
				dy = -dy;
			}
		}else if( type == 5 || type == 11 ){
			
			if( x > (Game.width - 60) && dx > 0 ){
				
				dx = -dx;
			}
			
			if( y > (Game.height - 60) && dy > 0 ){
				
				dy = -dy;
			}
		}else if( type == 6 || type == 12 ){
			
			if( x > (Game.width - 70) && dx > 0 ){
				
				dx = -dx;
			}
			
			if( y > (Game.height - 70) && dy > 0 ){
				
				dy = -dy;
			}
		}else if( type == 13 || type == 15){
			
			if( x > (Game.width - 47) && dx > 0 ){
				
				dx = -dx;
			}
			
			if( y > (Game.height - 47) && dy > 0 ){
				
				dy = -dy;
			}
		}else if( type == 14 || type == 16 ){
			
			if( x > (Game.width - 58) && dx > 0 ){
				
				dx = -dx;
			}
			
			if( y > (Game.height - 58) && dy > 0 ){
				
				dy = -dy;
			}
		}
	}
	
	/*
	 * This method renders every types of comets in each frame
	 */
	public void render(Graphics g){
		
		if( type == 1 ){
			
			g.drawImage(Assets.comet1 , (int) x , (int) y , 22 , 22 , null);
		}else if( type == 2 ){
			
			g.drawImage(Assets.comet2 , (int) x , (int) y , 32 , 32 , null);
		}else if( type == 3 ){
			
			g.drawImage(Assets.comet3 , (int) x , (int) y , 38 , 38 , null);
		}else if( type == 4 ){
			
			g.drawImage(Assets.comet4 , (int) x , (int) y , 48 , 48 , null);
		}else if( type == 5 ){
			
			g.drawImage(Assets.comet5 , (int) x , (int) y , 60 , 60 , null);
		}else if( type == 6 ){
			
			g.drawImage(Assets.comet6 , (int) x , (int) y , 70 , 70 , null);
		}else if( type == 7 ){
			
			g.drawImage(Assets.comet7 , (int) x , (int) y , 22 , 22 , null);
		}else if( type == 8 ){
			
			g.drawImage(Assets.comet8 , (int) x , (int) y , 32 , 32 , null);
		}else if( type == 9 ){
			
			g.drawImage(Assets.comet9 , (int) x , (int) y , 38 , 38 , null);
		}else if( type == 10 ){
			
			g.drawImage(Assets.comet10 , (int) x , (int) y , 48 , 48 , null);
		}else if( type == 11 ){
			
			g.drawImage(Assets.comet11 , (int) x , (int) y , 60 , 60 , null);
		}else if( type == 12 ){
			
			g.drawImage(Assets.comet12 , (int) x , (int) y , 70 , 70 , null);
		}else if( type == 13 ){
			
			g.drawImage(Assets.comet13 , (int) x , (int) y , 47 , 47 , null);
		}else if( type == 14 ){
			
			g.drawImage(Assets.comet14 , (int) x , (int) y , 58 , 58 , null);
		}else if( type == 15 ){
			
			g.drawImage(Assets.comet15 , (int) x , (int) y , 47 , 47 , null);
		}else if( type == 16 ){
			
			g.drawImage(Assets.comet16 , (int) x , (int) y , 58 , 58 , null);
		}
	}
	
	/*
	 * This method deals with different types and ranks of comets
	 */
	public void cometTypes(){
		
		if( type == 1 || type == 7 ){
			
			if( rank == 1 ){
				
				speed = 1.5;
				health = 1;
			}else if( rank == 2 ){
				
				speed = 2;
				health = 1;
			}
		}
		
		if( type == 2 || type == 8){
			
			if( rank == 1 ){
				
				speed = 2.5;
				health = 2;
			}else if( rank == 2 ){
				
				speed = 3;
				health = 2;
			}
		}
		
		if( type == 3 || type == 9 ){
			
			if( rank == 1 ){
				
				speed = 3.2;
				health = 3;
			}else if( rank == 2 ){
				
				speed = 3.7;
				health = 3;
			}
		}
		
		if( type == 4  || type == 10){
			
			if( rank == 1 ){
				
				speed = 2.7;
				health = 4;
			}else if( rank == 2 ){
				
				speed = 2.2;
				health = 5;
			}
		}
		
		if( type == 5 || type == 11){
			
			if( rank == 1 ){
				
				speed = 2.3;
				health = 6;
			}else if( rank == 2 ){
				
				speed = 1.8;
				health = 7;
			}
		}
		
		if( type == 6  || type == 12){
			
			if( rank == 1 ){
				
				speed = 1.7;
				health = 8;
			}else if( rank == 2 ){
				
				speed = 1.2;
				health = 9;
			}
		}
		
		if( type == 13 || type == 15 ){
			
			if( rank == 1 ){
				
				speed = 2.5;
				health = 2;
			}else if( rank == 2 ){
				
				speed = 3;
				health = 2;
			}
		}
		
		if( type == 14 || type == 16){
			
			if( rank == 1 ){
				
				speed = 2.7;
				health = 4;
			}else if( rank == 2 ){
				
				speed = 2.2;
				health = 5;
			}
		}
	}
	
	/*
	 * This method get called when the player hits the comets
	 */
	public void hit(){
		
		health--;
		
		if( health <= 0 ){
			
			destroyed = true;
		}
	}
	
	/*
	 * This method deals with the explosion of 
	 * different types and ranks of comets
	 */
	public void explode(){
		
		if( type == 3 ){
			
			amount = 3;
			
			if( rank == 1 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(1 , 1);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}else if( rank == 2 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(1 , 2);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}
		}else if( type == 9 ){
			
			amount = 3;
			
			if( rank == 1 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(7 , 1);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}else if( rank == 2 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(7 , 2);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}
		}else if( type == 4 ){
			
			amount = 4;
			
			if( rank == 1 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(2 , 2);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}else if( rank == 2 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(2 , 1);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}
		}else if( type == 10 ){
			
			amount = 4;
			
			if( rank == 1 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(8 , 2);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}else if( rank == 2 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(8 , 1);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}
		}else if( type == 5 ){
			
			amount = 5;
			
			if( rank == 1 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(13 , 2);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}else if( rank == 2 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(13 , 1);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}
		}else if( type == 6 ){
			
			amount = 5;
			
			if( rank == 1 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(14 , 2);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}else if( rank == 2 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(14 , 1);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}
		}else if( type == 11 ){
			
			amount = 5;
			
			if( rank == 1 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(15 , 1);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}else if( rank == 2 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(15 , 2);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}
		}else if( type == 12 ){
			
			amount = 5;
			
			if( rank == 1 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(16 , 1);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}else if( rank == 2 ){
				
				for( int i=0; i<amount; i++ ){
					
					Comets c = new Comets(16 , 2);
					
					c.x = this.x;
					c.y = this.y;
					
					double angle = 0;
					
					if( !ready ){
						
						angle = Math.random() * 150 + 50;
					}else{
						
						angle = Math.random() * 360;
					}
					
					c.radians = Math.toRadians(angle);
					GameState.comets.add(c);
				}
			}
		}		
	}
	
	// Getters and setters
	
	public boolean isDestroyed(){
		
		return destroyed;
	}
	
	public int getType(){
		
		return type;
	}
	
	public int getRank(){
		
		return rank;
	}
	
	public double getX(){
		
		return x;
	}
	
	public double getY(){
		
		return y;
	}
	
	public void setSlow( boolean slow ){
		
		this.slow = slow;
	}
}
