package vectorandscalar.animals;

import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.HP;
import vectorandscalar.SpriteHandler;

public class Sheep extends Animal{

	public Sheep(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		spriteHandler = new SpriteHandler(parent);			
		speed = 0.1f;
		direction = -1;
		hp = new HP(parent, 3, false);
		
		setDelay();
		sprite = spriteHandler.loadSpriteNew(8, 112, 39, 119, 4, 1, 1);		
		
	}
	
	@Override
	public void update(){				
		animalAIMovement();	
		xPos += (parent.frameRate / 60 * speed * direction);	
		
		if(direction < 0){
			hp.setX(xPos - 6);
		}
		if(direction > 0){
			hp.setX(xPos);
		}
		
		hp.setY(yPos-7);
	}
	
	@Override
	public void draw(){	
		parent.scale(direction, 1);
		parent.image(sprite[parent.frameCount/10 % sprite.length], xPos * direction, yPos);
		
		parent.scale(direction, 1);
		hp.draw();
		
	}
}