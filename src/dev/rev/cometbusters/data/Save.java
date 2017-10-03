package dev.rev.cometbusters.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Save {

	public static GameData gameData;
	
	public Save(){
		
		init();
	}
	
	public static void save(){
		
		try{
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("highscores.sav"));
			
			out.writeObject(gameData);
			out.close();
		}catch( Exception e ){
			
			e.printStackTrace();
		}
	}
	
	public static void load(){
		
		try{
			
			if( !saveFileExists() ){
				
				init();
				return;
			}
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("highscores.sav"));
			
			gameData = (GameData) in.readObject();
			in.close();
		}catch( Exception e ){
			
			e.printStackTrace();
		}
	}
	
	public static boolean saveFileExists(){
		
		File f = new File("highscores.sav");
		return f.exists();
	}

	public static void init(){
		
		gameData = new GameData();
		gameData.init();
		save();
	}
}
