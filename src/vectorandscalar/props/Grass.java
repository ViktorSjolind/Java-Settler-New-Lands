package vectorandscalar.props;

import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.SpriteHandler;

public class Grass extends Prop{	

	public Grass(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);
		variation = (int) parent.random(7);
		
		sprite = spriteHandler.loadSpriteNew(8, 96, 63, 103, 7, 1, 1);
		
		
	}
	
	
	
	public void draw(){		
		
		parent.image(sprite[variation], xPos, yPos);
		
	}


}
