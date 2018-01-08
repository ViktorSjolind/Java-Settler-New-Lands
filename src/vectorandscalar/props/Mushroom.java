package vectorandscalar.props;

import processing.core.PApplet;
import vectorandscalar.SpriteHandler;

public class Mushroom extends Prop {
	

	public Mushroom(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);
		
		sprite = spriteHandler.loadSpriteNew(136, 264, 143, 271, 1, 1, 1);
	}
	
	
	
	public void draw(){		
		
		parent.image(sprite[0], xPos, yPos);					
		
	}


}
