package dev.rev.cometbusters;

public class Launcher {

	public static void main( String [] args ){
		
		// Passing title of the window along with width and height of the window
		Game game = new Game("Comet Busters Reloaded" , 640 , 960);
		game.start();
	}
}
