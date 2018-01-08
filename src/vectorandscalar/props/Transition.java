package vectorandscalar.props;

import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.SpriteHandler;

public class Transition extends Prop {	
	
	public Transition(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);		
		
		sprite = spriteHandler.loadSpriteNew(8, 168, 95, 215, 1, 1, 1);
		
	}	
	
	public void draw(){				
		parent.image(sprite[0], xPos , yPos );			
		
	}
	
}
