package vectorandscalar.props;

import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.SpriteHandler;

public class Grass2 extends Prop{	

	public Grass2(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);
		variation = (int) parent.random(6);
		
		sprite = spriteHandler.loadSpriteNew(120, 272, 167, 279, 6, 1, 1);
		
		
	}
	
	
	public void draw(){		
		
		parent.image(sprite[variation], xPos, yPos);
		
	}


}
