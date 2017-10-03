package dev.rev.cometbusters.states;

import java.awt.Graphics;

import dev.rev.cometbusters.Game;

public abstract class State {
	
	private static State currentState = null;
	
	protected Game game;
	
	public static long scores = 0;
	
	// Constructor
	public State( Game game ){
		
		this.game = game;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	// Getters and Setters

	public static State getState(){
		
		return currentState;
	}

	public static void setState(State state){
		
		State.currentState = state;
	}
}
