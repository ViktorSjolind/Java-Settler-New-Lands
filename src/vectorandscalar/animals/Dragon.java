package vectorandscalar.animals;


import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.HP;
import vectorandscalar.MainSettlers;
import vectorandscalar.SpriteHandler;

public class Dragon extends Animal{		
	
	//Variables for fighting behavior
	private Player player;
	private boolean swinging;
	
	private float attackRange = 8;
	private float detectionRange = 24;
	private float attackInterval = 700f;
	private int meleeDamage = 1;
	private float nextAttack = 0; 
	
	private PImage[] spriteDragonFire;
	
	public Dragon(PApplet parent, int xPos, int yPos, Player player){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.player = player;
		swinging = false;
		spriteHandler = new SpriteHandler(parent);			
		speed = 0.1f;
		direction = -1;
		hp = new HP(parent, 3, false);
		
		setDelay();
		sprite = spriteHandler.loadSpriteNew(224, 256, 319, 271, 4, 3, 2);	
		spriteDragonFire = spriteHandler.loadSpriteNew(328, 256, 351, 263, 3, 1, 1);
		System.out.println(player);
		
	}	
	
	@Override
	public void update(){
		animalAIMovement();			
		animalAIFighting();
		xPos += (parent.frameRate / 60 * speed * direction);
		
		if(direction < 0){
			hp.setX(xPos - 16);
		}
		if(direction > 0){
			hp.setX(xPos + 8);
		}
		
		hp.setY(yPos - 7);
	}
	
	@Override
	public void draw(){			
		parent.scale(direction, 1);	
		
		parent.image(sprite[parent.frameCount/10 % sprite.length], xPos * direction, yPos);
		
		if(swinging){
			//xPos * direction
			parent.image(spriteDragonFire[parent.frameCount/20 % 2], xPos * direction + 25, yPos + 2);
		}

		parent.scale(direction, 1);	
		hp.draw();
		
	}
	
	//start fighting before timer
	//draws only when skeleton is going right and not left
	public void animalAIFighting(){
		
		float distance = Math.abs(	this.xPos - 40 - MainSettlers.getXOffset());		
		//System.out.println("skeleton: "  + distance + "\t" + swinging + "\t " + direction);
		
		if(distance <= detectionRange){
			swinging = true;
		}else{
			swinging = false;
		}
		
		
		if(parent.millis() >= nextAttack && distance <= attackRange){			
			nextAttack = parent.millis() + attackInterval;			
			System.out.println("dragon hits");			
			player.changeHP(-meleeDamage);			
		}
			
			
	}
	
	

}
