package dev.rev.cometbusters;

import java.awt.Graphics;

import java.awt.image.BufferStrategy;

import dev.rev.cometbusters.display.Display;
import dev.rev.cometbusters.gfx.Assets;
import dev.rev.cometbusters.input.KeyManager;
import dev.rev.cometbusters.input.MouseManager;
import dev.rev.cometbusters.states.GameOverState;
import dev.rev.cometbusters.states.GameState;
import dev.rev.cometbusters.states.HighScoreState;
import dev.rev.cometbusters.states.MenuState;
import dev.rev.cometbusters.states.OptionState;
import dev.rev.cometbusters.states.SplashScreenState;
import dev.rev.cometbusters.states.State;

public class Game implements Runnable {

	private Display display;

	private Thread thread;

	public String title;
	public static int width;
	public static int height;
	private boolean running = false;

	private BufferStrategy bs;
	private Graphics g;

	// States Declaration
	public State splashScreenState;
	public State menuState;
	public State gameState;
	public State highScoreState;
	public State optionState;
	public State gameOverState;

	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	// Constructor
	public Game( String title , int width , int height ){

		this.title = title;
		this.width = width;
		this.height = height;
		this.keyManager = new KeyManager();
		this.mouseManager = new MouseManager();
	}

	/*
	 * This method initializes the display, add key listeners to the frame,
	 * initializes all the assets as well as all the states and finally set
	 * the initial state
	 */
	private void init(){

		display = new Display(title , width , height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		splashScreenState = new SplashScreenState(this);
		menuState = new MenuState(this);
		gameState = new GameState(this);
		gameOverState = new GameOverState(this);
		highScoreState = new HighScoreState(this);
		optionState = new OptionState(this);

		State.setState(splashScreenState);
	}

	/*
	 * This method tick or update every calculations for input manager
	 * and the current state
	 */
	private void tick(){

		keyManager.tick();

		if( State.getState() != null ){

			State.getState().tick();
		}
	}

	/*
	 * This method render or draw every objects of the current state
	 */
	private void render(){

		// Getting the buffer strategy of the canvas
		bs = display.getCanvas().getBufferStrategy();

		if( bs == null ){

			// Creating 3 buffers for the canvas
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		// Clearing out the screen
		g.clearRect(0, 0, width, height);

		if( State.getState() != null ){

			State.getState().render(g);
		}

		// Showing the buffer
		bs.show();
		g.dispose();
	}

	@Override
	public void run() {

	  init();

	  int fps = 60;
	  double timePerTick = 1000000000 / fps;
	  double delta = 0;
	  long now;
	  long lastTime = System.nanoTime();
	  long timer = 0;
	  int ticks = 0;

	  // Game Loop
	  while(running){

	    now = System.nanoTime();
	    delta += (now - lastTime) / timePerTick;
	    timer += now - lastTime;
	    lastTime = now;

	    if( delta >= 1 ){

	      tick();
	      render();
	      ticks++;
	      delta--;
	    }

	    if( timer >= 1000000000 ){

	      System.out.println("Ticks and Frames : " + ticks);
	      ticks = 0;
	      timer = 0;
	    }
	  }

	  stop();
	}

	public synchronized void start(){

	  if(running){

	    return;
	  }

	  running = true;

	  thread = new Thread(this);
	  thread.start();
	}

	public synchronized void stop(){

	  if( !running ){

	    return;
	  }

	  running = false;

	  try {

	    thread.join();
	  } catch (InterruptedException e) {

	    e.printStackTrace();
	  }
	}

	// Getters and setters
	public KeyManager getKeyManager(){

		return keyManager;
	}

	public MouseManager getMouseManager(){

		return mouseManager;
	}

	public void setRunning( boolean running ){

		this.running = running;
	}

	public boolean getRunning(){

		return running;
	}

	public int getWidth(){

		return width;
	}

	public int getHeight(){

		return height;
	}
}
