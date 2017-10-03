package dev.rev.cometbusters.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width;
	private int height;
	
	private URL iconURL = getClass().getResource("/textures/icon.png");
	
	private ImageIcon icon;
	
	// Constructor
	public Display( String title , int width , int height ){
		
		this.title = title;
		this.width = width;
		this.height = height;
		this.icon = new ImageIcon(iconURL);
		
		createDisplay();
	}
	
	/*
	 * This method set all the properties of JFrame, set the 
	 * dimensions of the canvas and finally add the canvas 
	 * to the frame
	 */
	public void createDisplay(){
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(icon.getImage());
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width , height));
		canvas.setMaximumSize(new Dimension(width , height));
		canvas.setMinimumSize(new Dimension(width , height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	// Getters
	public Canvas getCanvas(){
		
		return canvas;
	}
	
	public JFrame getFrame(){
		
		return frame;
	}
}
