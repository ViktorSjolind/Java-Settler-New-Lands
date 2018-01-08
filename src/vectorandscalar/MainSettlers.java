package vectorandscalar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.event.MouseEvent;
import vectorandscalar.animals.Animal;
import vectorandscalar.animals.Player;
import vectorandscalar.props.Merchant;
import vectorandscalar.props.Prop;


public class MainSettlers extends PApplet{	
		
	private static final String VERSION = "0.1 Alpha";
	private MapGenerator mapGenerator;
	private List<Object> removeList;
	private Player player;
	private Merchant merchant;
	
	private static float xOffset = 0;
	private float xOffsetValue = 0;	
	
	
	public static void main(String[] args) {
		try {
		    // body of main method goes here, including any other error handling
		  } catch (Throwable t) {
		    JOptionPane.showMessageDialog(
		        null, t.getClass().getSimpleName() + ": " + t.getMessage());
		    throw t; // don't suppress Throwable
		  }
		
		PApplet.main("vectorandscalar.MainSettlers");
		

	}
	
	
	public void settings(){		
		size(1280, 720);
		noSmooth();
		
		
    }

    public void setup(){
    	surface.setTitle("Settler New Lands " + VERSION);
    	surface.setIcon(loadImage("icon3.png"));   	    	   	
    
    	//start game
    	fill(80);    	        
    	mapGenerator = new MapGenerator(this);    	
    	player = mapGenerator.getPlayer();	
    	merchant = mapGenerator.getMerchant();
    	removeList = new ArrayList<Object>();    	
    	
    }       

    public void draw(){    	
    	if(xOffset < 400){
    		background(89, 165, 211); 
    	}
    	   
    	if(xOffset >= 400){
    		background(58, 96,102);
    	}
    	
    	scale(16);
    	//println(frameRate);    	
    	
    	pushMatrix();
    	translate(-xOffset, 0);    	    	
    	
    	for(Prop tree: mapGenerator.treeList){
    		tree.draw();
    	}
    	
    	for(Prop mineral: mapGenerator.mineralList){
    		mineral.draw();
    	}
    	
    	for(Prop prop: mapGenerator.propsList){
    		prop.draw();
    	}
    	
    	merchant.draw();
    	
    	for(Animal animal: mapGenerator.animalList){
    		animal.update();    	
    		if(animal.isDead()){
    			removeList.add(animal);
    		}
    	}      	
    	mapGenerator.animalList.removeAll(removeList);
    	
    	for(Animal animal: mapGenerator.animalList){
    		animal.draw();
    		
    	}    		    	
    	
    	popMatrix();
    	
    	
    	player.update();    	
    	player.draw();
    	
    
    	xOffset += xOffsetValue;
    	
    
    	
    }
    
    public static float getXOffset(){
    	return xOffset;
    }
    
    
    
    public void keyPressed(){
		if(keyCode == LEFT || keyCode == 'a' || keyCode == 'A'){
			
			xOffsetValue = -player.getSpeed();
			player.setWalking(true);
			player.setDirection(-1);
		}
		
		if(keyCode == RIGHT || keyCode == 'd' || keyCode == 'D'){
			
			xOffsetValue = player.getSpeed();
			player.setWalking(true);
			player.setDirection(1);

		}
		
		if(keyCode == 'q' || keyCode == 'Q'){
			player.decState();
		}
		
		if(keyCode == 'e' || keyCode == 'E'){
			player.incState();
		}
		
		if(keyCode == ' '){
			player.changeSwinging(true);
			
		}
		
		if(keyCode == 'z' || keyCode == 'Z'){
			
		}
		
		if(keyCode == 'i' || keyCode == 'I'){			
			player.toggleGUI();
		}
		
		
		
	}
    
    public void keyReleased(){
		if(keyCode == LEFT || keyCode == RIGHT || keyCode == 'a' || keyCode == 'A' || keyCode == 'd' || keyCode == 'D'){
			xOffsetValue = 0;
			player.setWalking(false);

		}
		
		if(keyCode == ' '){
			player.changeSwinging(false);
			
			//nothing in hands
			if(player.getState() == 3){
				
			}
		}
	}
    
    public void mousePressed(){
    	if(mouseButton == LEFT){    		
    		//eat food from inventory
    		if(mouseX >= 1120 && mouseX <= 1170 && mouseY >= 565 && mouseY <= 600){
    			System.out.println("food clicked");
    			if(player.getFood() > 0 && player.hp.getHP() < player.hp.getMaxHP()){
    				player.changeFood(-1);
    				player.hp.changeHP(1);
    			}    			
    		}    		
    		
    		if(mouseX >= merchant.merchantGUI.square1X && mouseX <= merchant.merchantGUI.square1X+2){
    			System.out.println("buy wood");
    		}
    		
    		
    	}
    }
	
    
	public void mouseWheel(MouseEvent event){		
		float e = event.getCount() * -1;
		
		if(e>0){
			player.incState();
		}else{
			player.decState();
		}
		
		
	}
	
	
	public Player getPlayer(){
		return player;
	}
    
    
    
    
    
	
	
	
	
	
	
}
