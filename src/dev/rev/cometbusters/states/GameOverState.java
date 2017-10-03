package dev.rev.cometbusters.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import dev.rev.cometbusters.Game;
import dev.rev.cometbusters.data.Save;
import dev.rev.cometbusters.gfx.Assets;
import dev.rev.cometbusters.ui.ClickListener;
import dev.rev.cometbusters.ui.UIImageButton;
import dev.rev.cometbusters.ui.UIManager;

public class GameOverState extends State {

	private UIManager uiManager;
	
	private boolean newHighScore;
	private char [] newName;
	private int currentChar;
	
	private String background = "/textures/background.png";
	
	// Constructor
	public GameOverState(Game game) {
		
		super(game);
		
		uiManager = new UIManager(game);
		
		game.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(240 , 780 , 159 , 40 , Assets.btnBack, new ClickListener(){

			@Override
			public void onClick() {
				
				State.setState(game.menuState);
			}
		}));
		
		init();
	}
	
	/*
	 * Initializes user name input
	 */
	public void init(){
		
		newHighScore = true;
		
		if( newHighScore ){

			newName = new char [] {'A' , 'A' , 'A'};
			currentChar = 0;
		}
	}

	@Override
	public void tick() {

		game.getMouseManager().setUIManager(uiManager);
		getInput();
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		
		// Rendering background image
		g.drawImage(getBackgroundImage() , 0 , 0 , null);
		
		g.setColor(Color.white);
		g.setFont(new Font("Agency FB" , Font.PLAIN , 60));
		String s = "G A M E  O V E R";
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s , (game.getWidth() - length) / 2, game.getHeight() / 2 - 70);
		
		g.setFont(new Font("Agency FB" , Font.PLAIN , 40));
		s = "YOUR SCORE : " + scores;
		length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s , (game.getWidth() - length) / 2, game.getHeight() / 2 - 20);
		
		g.setFont(new Font("Agency FB" , Font.PLAIN , 32));
		s = "ENTER YOUR NAME BY SCROLLING CHARACTERS";
		length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s , (game.getWidth() - length) / 2, game.getHeight() / 2 + 20);
		
		g.setFont(new Font("Agency FB" , Font.PLAIN , 32));
		s = "PRESS 'ENTER'";
		length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s , (game.getWidth() - length) / 2, game.getHeight() / 2 + 150);
		
		if( !newHighScore ){
			
			return;
		}
		
		for( int i=0; i<3; i++ ){
			
			g.setFont(new Font("Agency FB" , Font.PLAIN , 32));
			g.drawString(Character.toString(newName[i]) , 280 + 30 * i , game.getHeight() / 2 + 70);
		}
		
		uiManager.render(g);
	}
	
	// Getters
	
	public Image getBackgroundImage(){
		
		ImageIcon icon = new ImageIcon(getClass().getResource(background));
		return icon.getImage();
	}
	
	public void getInput(){
		
		if( game.getKeyManager().enter ){
			
			if( newHighScore ){
				
				Save.gameData.addHighScore(scores, new String(newName));
				Save.save();
			}
			
			State.setState(game.menuState);
			return;
		}
		
		if( game.getKeyManager().upArrow ){
			
			if( newName[currentChar] == ' ' ){
				
				newName[currentChar] = 'Z';
			}else{
				
				newName[currentChar]--;
				
				if( newName[currentChar] < 'A' ){
					
					newName[currentChar] = ' ';
				}
			}
		}
		
		if( game.getKeyManager().downArrow ){
			
			if( newName[currentChar] == ' ' ){
				
				newName[currentChar] = 'A';
			}else{
				
				newName[currentChar]++;
				
				if( newName[currentChar] > 'Z' ){
					
					newName[currentChar] = ' ';
				}
			}
		}
		
		if( game.getKeyManager().rightArrow ){
			
			if( currentChar < 2 ){
				
				currentChar++;
			}
		}
		
		if( game.getKeyManager().leftArrow ){
			
			if( currentChar > 0 ){
				
				currentChar--;
			}
		}
	}
}
