package dev.rev.cometbusters.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	// Sprite
	public static BufferedImage logo;
	
	public static BufferedImage player1;
	public static BufferedImage player2;
	public static BufferedImage player3;
	
	public static BufferedImage lives;
	public static BufferedImage power;
	public static BufferedImage shipMode;
	
	public static BufferedImage laser;
	public static BufferedImage powerUp;
	public static BufferedImage health;
	public static BufferedImage modes;
	public static BufferedImage scoreTen;
	public static BufferedImage scoreFifty;
	public static BufferedImage scoreHundred;
	
	public static BufferedImage slowDownPill;
	
	public static BufferedImage comet1;
	public static BufferedImage comet2;
	public static BufferedImage comet3;
	public static BufferedImage comet4;
	public static BufferedImage comet5;
	public static BufferedImage comet6;
	public static BufferedImage comet7;
	public static BufferedImage comet8;
	public static BufferedImage comet9;
	public static BufferedImage comet10;
	public static BufferedImage comet11;
	public static BufferedImage comet12;
	public static BufferedImage comet13;
	public static BufferedImage comet14;
	public static BufferedImage comet15;
	public static BufferedImage comet16;
	
	public static BufferedImage [] btnStart;
	public static BufferedImage [] btnScore;
	public static BufferedImage [] btnOption;
	public static BufferedImage [] btnExit;
	public static BufferedImage [] btnBack;
	public static BufferedImage [] btnSoundOn;
	public static BufferedImage [] btnSoundOff;
	
	/*
	 * This method load the sprite sheet and crop every 
	 * single sprite from the sprite sheet
	 */
	public static void init(){
		
		// Loading the sprite sheet
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		btnStart = new BufferedImage[2];
		btnScore = new BufferedImage[2];
		btnOption = new BufferedImage[2];
		btnExit = new BufferedImage[2];
		btnBack = new BufferedImage[2];
		btnSoundOn = new BufferedImage[2];
		btnSoundOff = new BufferedImage[2];
		
		// Cropping each and every single sprite
		logo = sheet.crop(1 , 194 , 529 , 222);
		
		player1 = sheet.crop(1 , 0 , 112 , 75);
		player2 = sheet.crop(120 , 0 , 99 , 75);
		player3 = sheet.crop(231 , 0 , 98 , 75);
		
		comet1 = sheet.crop(725 , 0 , 18 , 18);
		comet2 = sheet.crop(786 , 0 , 29 , 26);
		comet3 = sheet.crop(874 , 0 , 45 , 40);
		comet4 = sheet.crop(612 , 0 , 43 , 43);
		comet5 = sheet.crop(982 , 0 , 89 , 82);
		comet6 = sheet.crop(987 , 105 , 101 , 84);
		comet7 = sheet.crop(752 , 0 , 16 , 15);
		comet8 = sheet.crop(827 , 0 , 28 , 28);
		comet9 = sheet.crop(924 , 0 , 43 , 43);
		comet10 = sheet.crop(666 , 0 , 45 , 40);
		comet11 = sheet.crop(1102 , 104 , 98 , 96);
		comet12 = sheet.crop(1080 , 0 , 120 , 98);
		comet13 = sheet.crop(840 , 52 , 98 , 96);
		comet14 = sheet.crop(842 , 271 , 120 , 98);
		comet15 = sheet.crop(841 , 158 , 89 , 82);
		comet16 = sheet.crop(980 , 286 , 101 , 84);
		
		lives = sheet.crop(358 , 45 , 31 , 30);
		power = sheet.crop(398 , 45 , 19 , 30);
		shipMode = sheet.crop(428 , 45 , 30 , 30);
		
		laser = sheet.crop(334 , 0 , 9 , 37);
		powerUp = sheet.crop(390 , 0 , 34 , 33);
		health = sheet.crop(356 , 0 , 34 , 33);
		modes = sheet.crop(424 , 0 , 34 , 33);
		scoreTen = sheet.crop(464 , 0 , 32 , 32);
		scoreFifty = sheet.crop(496 , 0 , 32, 32);
		scoreHundred = sheet.crop(528 , 0 , 32, 32);
		
		slowDownPill = sheet.crop(469 , 45 , 22 , 21);
		
		btnStart[0] = sheet.crop(0 , 92 , 159 , 40);
		btnStart[1] = sheet.crop(0 , 136 , 159 , 40);
		btnScore[0] = sheet.crop(164 , 92 , 159 , 40);
		btnScore[1] = sheet.crop(164 , 136 , 159 , 40);
		btnOption[0] = sheet.crop(329 , 92 , 159 , 40);
		btnOption[1] = sheet.crop(329 , 136 , 159 , 40);
		btnExit[0] = sheet.crop(494 , 92 , 159 , 40);
		btnExit[1] = sheet.crop(494 , 136 , 159 , 40);
		btnBack[0] = sheet.crop(660 , 92 , 159 , 40);
		btnBack[1] = sheet.crop(660 , 136 , 159 , 40);
		btnSoundOn[0] = sheet.crop(660 , 185 , 74 , 38);
		btnSoundOn[1] = sheet.crop(745 , 185 , 74 , 38);
		btnSoundOff[0] = sheet.crop(660 , 233 , 74 , 38);
		btnSoundOff[1] = sheet.crop(745 , 233 , 74 , 38);
	}
}
