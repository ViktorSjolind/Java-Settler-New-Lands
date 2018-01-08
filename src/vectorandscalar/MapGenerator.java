package vectorandscalar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import processing.core.PApplet;
import vectorandscalar.animals.*;
import vectorandscalar.props.*;

public class MapGenerator {
	private String map[][];
	protected List<Prop> treeList;
	protected List<Prop> mineralList;
	protected List<Prop> propsList;	
	protected List<Animal> animalList;
	
	private Player player;
	private Merchant merchant;
	
	private PApplet parent;
	private static final String MAP_PATH = "res/Map";
	
	public MapGenerator(PApplet parent){		
		this.parent = parent;
		
		treeList = new ArrayList<Prop>();
		mineralList = new ArrayList<Prop>();
		propsList = new ArrayList<Prop>();		
		animalList = new ArrayList<Animal>();
		
		loadMapFromFile();
		placeMap();
	}
	
	public void loadMapFromFile(){
		map = new String[6][100];
		
		try {			
			
			
			InputStream in = ClassLoader.getSystemResourceAsStream("Map.txt");
			
			
			//ClassLoader classLoader = getClass().getClassLoader();			
			//File file = new File(classLoader.getResource("Map.txt").getFile());			
			
			Scanner input = new Scanner(in);
			int y = 0;
			String row;
			
			while(input.hasNextLine()){
				row = input.nextLine();		
				row = row.replaceAll("\\s+","");
				map[y] = row.split(",");
				y++;		
			}			
			
			input.close();
			
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Merchant getMerchant(){
		return merchant;
	}
	
	
	public void placeMap(){
    	for(int y = 0; y < map.length; y++){
    		for(int x = 0; x < map[y].length; x++){    			
    			
    			switch(map[y][x]){
    			case "1":
    				propsList.add(new Ground(parent, x*8, y * 8));
    				break;
    				
    			case "2":
    				propsList.add(new Grass(parent, x*8, y * 8));
    				break;    				
    			
    			case "3":
    				treeList.add(new Tree(parent, x*8, y * 8));
    				break;
    				
    			case "4":
    				mineralList.add(new Stone(parent, x*8, y * 8));
    				break;
    				
    			case "5":
    				propsList.add(new Fire(parent, x*8, y * 8));
    				break;
    			
    			
    			case "6":
    				
    				player = new Player(parent, x*8, 3 * 8, animalList, treeList, mineralList);
    				break;
    				
    			case "7":
    				animalList.add(new Steve(parent, x*8, y * 8));
    				break;
    				
    			case "8":
    				
    				animalList.add(new Skeleton(parent, x*8, y * 8, player));
    				break;	
    			
    			case "9":
    				propsList.add(new House(parent, x*8, y * 8));
    				break;
    				
    			case "10":
    				propsList.add(new Sky2(parent, x*8, y * 8));
    				break;
    			
    			case "11":
    				propsList.add(new Ground2(parent, x*8, y * 8));
    				break;
    				
    			case "12":
    				propsList.add(new Grass2(parent, x*8, y * 8));
    				break;    				
    			
    				
    			case "13":
    				treeList.add(new Tree2(parent, x*8, y * 8));
    				break;	
    				
    			case "14":
    				treeList.add(new Mountain(parent, x*8, y * 8));
    				break;	
    				
    				
    			case "15":
    				propsList.add(new Mushroom(parent, x*8, y * 8));
    				break;	
    				
    				
    				
    			case "16":
    				animalList.add(new Dragon(parent, x*8, y * 8, player));
    				break;
    				
    			
    			case "17":    				
    				propsList.add(new Bush2(parent, x*8, y * 8));
    				break;
    			
    				
    			case "21":    				
    				propsList.add(new Farm(parent, x*8, y * 8));
    				break;
    			
    			
    			case "22":    				
    				propsList.add(new Bush(parent, x*8, y * 8));
    				break;
    				
    				
    			case "23":    				
    				merchant = new Merchant(parent, x*8, y * 8);
    				break;	
    				
    				
    			case "24":    				
    				animalList.add(new Sheep(parent, x*8, y * 8));
    				break;	
    				
    			case "25":    				
    				animalList.add(new Princess(parent, x*8, y * 8));
    				break;	
    				
    			
    			}	 		
    			
    		}
    	}
    	
    	
    	
    	
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
