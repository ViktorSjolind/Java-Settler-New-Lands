package vectorandscalar.animals;

import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.HP;
import vectorandscalar.MainSettlers;
import vectorandscalar.SpriteHandler;

public class Skeleton extends Animal{		
	
	//Variables for fighting behavior
	private Player player;
	private boolean swinging;
	
	private float attackRange = 8;
	private float detectionRange = 24;
	private float attackInterval = 700f;
	private int meleeDamage = 1;
	private float nextAttack = 0; 
	
	private PImage[] spriteSword;
	
	public Skeleton(PApplet parent, int xPos, int yPos, Player player){
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
		sprite = spriteHandler.loadSprite(136, 167, 112, 119, 4);	
		spriteSword = spriteHandler.loadSprite1D(176, 207, 96, 103, 2, 2);
		System.out.println(player);
	}	
	
	@Override
	public void update(){
		animalAIMovement();			
		animalAIFighting();
		xPos += (parent.frameRate / 60 * speed * direction);
		
		if(direction < 0){
			hp.setX(xPos - 6);
		}
		if(direction > 0){
			hp.setX(xPos);
		}
		
		hp.setY(yPos - 7);
	}
	
	@Override
	public void draw(){			
		parent.scale(direction, 1);	
		
		parent.image(sprite[parent.frameCount/10 % sprite.length], xPos * direction, yPos);
		
		if(swinging){
			//xPos * direction
			parent.image(spriteSword[parent.frameCount/20 % 2], xPos * direction, yPos);
		}

		parent.scale(direction, 1);	
		hp.draw();
		
	}
	
	//start fighting before timer
	//draws only when skeleton is going right and not left
	public void animalAIFighting(){
		float distance = Math.abs(	this.xPos - player.getX() - MainSettlers.getXOffset());		
		//System.out.println("skeleton: "  + distance + "\t" + swinging + "\t " + direction);
		
		if(distance <= detectionRange){
			swinging = true;
		}else{
			swinging = false;
		}
		
		
		if(parent.millis() >= nextAttack && distance <= attackRange){			
			nextAttack = parent.millis() + attackInterval;			
			System.out.println("skeleton hits");			
			player.changeHP(-meleeDamage);			
		}
		
		
		
	}

}
