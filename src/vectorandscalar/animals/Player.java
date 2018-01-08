package vectorandscalar.animals;

import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.GUI;
import vectorandscalar.HP;
import vectorandscalar.MainSettlers;
import vectorandscalar.SpriteHandler;
import vectorandscalar.props.Prop;


public class Player extends Animal{

	private GUI gui;
	private boolean walking;	
	private boolean toggleGUI;
	//sword / axe / pickaxe
	private int state;
	//fighting or not
	private boolean swinging;	
	private PImage[] spritePlayer;
	private PImage[] spriteSword;	
	private PImage[] spriteAxe;	
	private PImage[] spritePickaxe;	
	private List<Animal> animalList;
	private List<Prop> treeList;
	private List<Prop> mineralList; 
	
	
	private int money;
	private int wood;
	private int stone;
	private int iron;
	private int food;
	
	
	//melee attack
	private float range = 16;
	private float attackInterval = 700f;
	private int meleeDamage = 1;
	private float nextAttack = 0;
	
	
	

	public Player(PApplet parent, int xPos, int yPos, List<Animal> animalList, List<Prop> treeList, List<Prop> mineralList){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.animalList = animalList;
		this.treeList = treeList;
		this.mineralList = mineralList;
		
		money = 100;
		wood = 0;
		stone = 0;
		iron = 0;
		food = 6;
		
		
		//0=sword, 1=axe, 2=pickaxe
		state = 0;
		swinging = false;
		
		toggleGUI = true;
		spriteHandler = new SpriteHandler(parent);			
		speed = 5f;
		direction = 1;
		hp = new HP(parent, 5, true);	
		gui = new GUI(parent, this);		
		
		spritePlayer = spriteHandler.loadSprite(176, 207, 104, 111, 4);
		spriteSword = spriteHandler.loadSprite1D(176, 207, 96, 103, 2, 2);
		spriteAxe = spriteHandler.loadSprite1D(208, 239, 96, 103, 2, 2);
		spritePickaxe = spriteHandler.loadSprite1D(240, 271, 96, 103, 2, 2);	
		
	}		
	
	public void update(){			
		gui.setX(xPos+7);	
		gui.setY(yPos+24);	
		
		hp.setX(xPos - 24);
		hp.setY(yPos - 24);	
		
		
		if(swinging){			
			if(state == 0){
				meleeAttack();
			}
			//woodcutting
			if(state == 1){
				woodCutting();
			}
			
			if(state == 2){
				mining();
			}
		}
		
	}
	
	public void draw(){		
		parent.scale(1 * direction, 1);			
		
		if(walking){
			parent.image(spritePlayer[parent.frameCount/10 % 4], xPos * direction, yPos);
		}		
		if(!walking){
			parent.image(spritePlayer[0], xPos * direction, yPos);
		}		
		
		if(swinging){
			switch(state){
				case 0:
					parent.image(spriteSword[parent.frameCount/20 % 2], xPos * direction, yPos);
					break;
					
				case 1:
					parent.image(spriteAxe[parent.frameCount/20 % 2], xPos * direction, yPos);
					break;
					
				case 2:
					parent.image(spritePickaxe[parent.frameCount/20 % 2], xPos * direction, yPos);
					break;
			}
		}
		
		if(!swinging){
			switch(state){
				case 0:
					parent.image(spriteSword[0], xPos * direction, yPos);
					break;
					
				case 1:
					parent.image(spriteAxe[0], xPos * direction, yPos);
					break;
					
				case 2:
					parent.image(spritePickaxe[0], xPos * direction, yPos);
					break;
			}
		}
		
		
		
		parent.scale(1 * direction, 0.7f);
		if(toggleGUI){
			gui.draw();
		}		
		hp.draw();
	}			
	
	
	public void changeSwinging(boolean value){
		if(!swinging && value){
			//start timer + animation
			swinging = true;
		}
		
		if(swinging && value){
			//do nothing, timer + animation should keep running
		}
		
		if(swinging && !value){
			//timer + animation should be stopped
			swinging = false;
		}
		
		
	}
	
	public void woodCutting(){
		//attack + magic number 
		if(parent.millis() > nextAttack + 5000){
			nextAttack = parent.millis() + attackInterval;			
			for(Prop tree: treeList){						
				float distance = Math.abs(	(tree.getX() + (8 * 3)/2)  - this.xPos - MainSettlers.getXOffset());	//8 = tile size, 
				if(distance <= range){
					
					System.out.println("cut");
					System.out.println("Player: " + xPos + ":" + yPos +      "| Tree: " + tree.getX() + ":" + "| Distance: " + distance);
					changeWood(1);
				}
			}
		}		
		
		
	}
	
	
	public void mining(){
		//attack + magic number 
		if(parent.millis() > nextAttack + 8000){
			nextAttack = parent.millis() + attackInterval;			
			for(Prop stone: mineralList){				
				float distance = Math.abs(	(stone.getX() + (8 /2))  - this.xPos - MainSettlers.getXOffset());
				if(distance <= range){
					
					System.out.println("cut");
					System.out.println("Player: " + xPos + ":" + yPos +      "| Stone: " + stone.getX() + ":" + "| Distance: " + distance);
					changeStone(1);
				}
			}
		}		
		
		
	}
	
	
	
	public void meleeAttack(){
		if(parent.millis() > nextAttack){
			nextAttack = parent.millis() + attackInterval;
			
			for(Animal animal: animalList){
				float distance = Math.abs(	animal.getX() - this.xPos - MainSettlers.getXOffset());
				if(distance <= range){
					System.out.println("hit");
					System.out.println("Player: " + xPos + ":" + yPos +      "| Enemy: " + animal.getX() + ":" + animal.getY() + "| Distance: " + distance);
					animal.changeHP(-meleeDamage);
				}
			}
		}
		
		
	}
	
	
	public void decState(){
		if(state >= 0){
			state--;
		}
		
		if(state == -1){
			state = 3;
		}
	}
	
	public void incState(){
		if(state <= 2){
			state++;
		}
		
		if(state == 3){
			state = 0;
		}
		
		
	}	
	
	public void toggleGUI(){
		toggleGUI = ! toggleGUI;
	}
	
	
	
	
	// movement related functions
	public void setWalking(boolean walking){
		this.walking = walking;
	}
	
	public void toggleWalking(){
		walking = !walking;
	}


	public void setDirection(int direction) {
		this.direction = direction;
		
	}
	
	public boolean getSwinging(){
		return swinging;
	}
	
	public int getState(){
		return state;
	}	
	
	//resources
	
	public int getMoney(){
		return money;
	}
	
	public int getWood(){
		return wood;
	}
	
	public int getStone(){
		return stone;
	}
	
	public int getIron(){
		return iron;
	}
	
	public int getFood(){
		return food;
	}
	
	
	//set
	
	public void setMoney(int amount){
		this.money = amount;
	}
	
	public void setWood(int amount){
		this.wood = amount;
	}
	
	public void setStone(int amount){
		this.stone = amount;
	}
	
	public void setIron(int amount){
		this.iron = amount;
	}
	
	public void setFood(int amount){
		this.food = amount;
	}
	
	//increment
	public void changeMoney(int amount){
		this.money += amount;
	}
	
	public void changeWood(int amount){
		this.wood += amount;
	}
	
	public void changeStone(int amount){
		this.stone += amount;
	}
	
	public void changeIron(int amount){
		this.iron += amount;
	}
	
	public void changeFood(int amount){
		this.food += amount;
	}
	
	
	
	
}

















