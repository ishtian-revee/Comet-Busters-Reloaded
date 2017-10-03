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

public class HighScoreState extends State {

	private UIManager uiManager;
	
	private long[] highScores;
	private String[] names;
	
	private String background = "/textures/background.png";
	
	// Constructor
	public HighScoreState(Game game){
		
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
	 * Initializes score data
	 */
	public void init(){
		
		Save.load();
		highScores = Save.gameData.getHighScores();
		names = Save.gameData.getNames();
	}
	
	@Override
	public void tick() {
		
		game.getMouseManager().setUIManager(uiManager);
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		
		// Rendering background image
		g.drawImage(getBackgroundImage() , 0 , 0 , null);
		
		g.setColor(Color.white);
		g.setFont(new Font("Agency FB" , Font.PLAIN , 40));
		String s = "HIGH SCORES";
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s , (game.getWidth() - length) / 2, game.getHeight() / 2 - 350);
		
		g.setFont(new Font("Agency FB" , Font.PLAIN , 30));
		
		for( int i=0; i<highScores.length; i++ ){
			
			s = String.format("%2d. %s %8s", i+1 , names[i] , highScores[i]);
			length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			g.drawString(s , (game.getWidth() - length) / 2, 250 + 50 * i);
		}
		
		uiManager.render(g);
	}
	
	// Getter
	
	public Image getBackgroundImage(){
		
		ImageIcon icon = new ImageIcon(getClass().getResource(background));
		return icon.getImage();
	}
}
