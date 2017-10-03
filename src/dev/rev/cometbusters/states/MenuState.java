package dev.rev.cometbusters.states;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import dev.rev.cometbusters.Game;
import dev.rev.cometbusters.audio.AudioPlayer;
import dev.rev.cometbusters.gfx.Assets;
import dev.rev.cometbusters.ui.ClickListener;
import dev.rev.cometbusters.ui.UIImageButton;
import dev.rev.cometbusters.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	
	private GameState gameState;
	
	private int music = 1;
	
	public static AudioPlayer backgroundMusic;
	
	private String background = "/textures/menuBackground.png";
	
	// Constructor
	public MenuState(Game game){
		
		super(game);
		
		uiManager = new UIManager(game);
		
		game.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(240 , 480 , 159 , 40 , Assets.btnStart, new ClickListener(){

			@Override
			public void onClick() {
				
				gameState = new GameState(game);
				State.setState(gameState);
			}
		}));
		
		uiManager.addObject(new UIImageButton(240 , 535 , 159 , 40 , Assets.btnScore, new ClickListener(){

			@Override
			public void onClick() {
				
				State.setState(game.highScoreState);
			}
		}));
		
		uiManager.addObject(new UIImageButton(240 , 590 , 159 , 40 , Assets.btnOption, new ClickListener(){

			@Override
			public void onClick() {
				
				State.setState(game.optionState);
			}
		}));
		
		uiManager.addObject(new UIImageButton(240 , 645 , 159 , 40 , Assets.btnExit, new ClickListener(){

			@Override
			public void onClick() {
				
				System.exit(1);
			}
		}));
			
		backgroundMusic = new AudioPlayer("/audio/background.mp3");
	}
	
	@Override
	public void tick() {
		
		game.getMouseManager().setUIManager(uiManager);
		uiManager.tick();
		
		if( music == 1 ){
			
			backgroundMusic.play(1);
			music++;
			
			// Just to make sure that 'music' never gets 1 again
			if( music >= 3 ){
				
				music = 3;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
		// Rendering background image
		g.drawImage(getBackgroundImage(), 1, -90, null);
		
		// Rendering game logo
		g.drawImage(Assets.logo , 55 , 60 , 529 , 222 , null);
		
		uiManager.render(g);
	}
	
	// Getter
	
	public Image getBackgroundImage(){
		
		ImageIcon icon = new ImageIcon(getClass().getResource(background));
		return icon.getImage();
	}
}
