package dev.rev.cometbusters.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean [] keys;
	
	public boolean upArrow;
	public boolean downArrow;
	public boolean leftArrow;
	public boolean rightArrow;
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean shoot;
	public boolean pause;
	public boolean enter;
	
	public KeyManager(){
		
		keys = new boolean[256];
	}
	
	/*
	 * This method setup all the keyboard keys and 
	 * update regularly
	 */
	public void tick(){
		
		upArrow = keys[KeyEvent.VK_UP];
		downArrow = keys[KeyEvent.VK_DOWN];
		leftArrow = keys[KeyEvent.VK_LEFT];
		rightArrow = keys[KeyEvent.VK_RIGHT];
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		shoot = keys[KeyEvent.VK_SPACE];
		pause = keys[KeyEvent.VK_ESCAPE];
		enter = keys[KeyEvent.VK_ENTER];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		System.out.println("Key Pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		

	}
}
