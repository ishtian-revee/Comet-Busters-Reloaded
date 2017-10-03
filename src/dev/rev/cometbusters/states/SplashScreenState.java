package dev.rev.cometbusters.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.rev.cometbusters.Game;

public class SplashScreenState extends State {

	private long splashScreenTimer;
	private long splashScreenTimerDiff;
	private int splashDelay = 7000;
	
	// Constructor
	public SplashScreenState(Game game) {
		
		super(game);
		
		splashScreenTimer = 0;
		splashScreenTimerDiff = 0;
	}

	@Override
	public void tick() {
		
		if( splashScreenTimer == 0 ){
			
			splashScreenTimer = System.nanoTime();
		}else{
			
			splashScreenTimerDiff = (System.nanoTime() - splashScreenTimer) / 1000000;
			
			if( splashScreenTimerDiff > splashDelay ){
				
				splashScreenTimer = 0;
				splashScreenTimerDiff = 0;
				State.setState(game.menuState);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
		
		if( splashScreenTimer != 0 ){
			
			int trans = (int) (255 * Math.sin(3.14 * splashScreenTimerDiff / splashDelay));
			
			if( trans > 255 ){
				
				trans = 255;
			}
			
			g.setColor(new Color(255 , 255 , 255 , trans));
			g.setFont(new Font("Agency FB" , Font.PLAIN , 90));
			String s = "COMET";
			int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			g.drawString(s, Game.width / 2 - length / 2, Game.height / 2 - 55);
			
			g.setFont(new Font("Agency FB" , Font.PLAIN , 100));
			s = "BUSTERS";
			length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			g.drawString(s, Game.width / 2 - length / 2, Game.height / 2 + 30);
			
			g.setFont(new Font("Agency FB" , Font.PLAIN , 60));
			s = "R E L O A D E D";
			length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			g.drawString(s, Game.width / 2 - length / 2, Game.height / 2 + 85);
		}
	}
}
