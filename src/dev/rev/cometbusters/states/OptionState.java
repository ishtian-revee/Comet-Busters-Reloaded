package dev.rev.cometbusters.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import dev.rev.cometbusters.Game;
import dev.rev.cometbusters.gfx.Assets;
import dev.rev.cometbusters.ui.ClickListener;
import dev.rev.cometbusters.ui.UIImageButton;
import dev.rev.cometbusters.ui.UIManager;

public class OptionState extends State {

	private UIManager uiManager;
	
	private String background = "/textures/background.png";
	
	// Constructor
	public OptionState(Game game) {
		
		super(game);
		
		uiManager = new UIManager(game);
		
		game.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(380 , 300 , 74 , 38 , Assets.btnSoundOn, new ClickListener(){

			@Override
			public void onClick() {
				
				MenuState.backgroundMusic.play(1);
			}
		}));
		
		uiManager.addObject(new UIImageButton(480 , 300 , 74 , 38 , Assets.btnSoundOff, new ClickListener(){

			@Override
			public void onClick() {
				
				MenuState.backgroundMusic.stop();
			}
		}));
		
		uiManager.addObject(new UIImageButton(240 , 780 , 159 , 40 , Assets.btnBack, new ClickListener(){

			@Override
			public void onClick() {
				
				State.setState(game.menuState);
			}
		}));
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
		String s = "Options";
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s , (game.getWidth() - length) / 2, game.getHeight() / 2 - 350);
		
		g.setFont(new Font("Agency FB" , Font.PLAIN , 34));
		s = "BACKGROUND MUSIC";
		length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s , (game.getWidth() - length) / 2 - 130, game.getHeight() / 2 - 150);
		
		uiManager.render(g);
	}
	
	// Getter
	
	public Image getBackgroundImage(){
		
		ImageIcon icon = new ImageIcon(getClass().getResource(background));
		return icon.getImage();
	}
}
