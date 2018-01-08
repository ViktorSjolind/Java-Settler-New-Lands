package vectorandscalar.props;

import processing.core.PApplet;
import vectorandscalar.SpriteHandler;

public class Ground2 extends Prop{

	public Ground2(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);
		
		sprite = spriteHandler.loadSpriteNew(168, 272, 175, 279, 1, 1, 1);	
		
	}
	
	
	
	public void draw(){		
		
		parent.image(sprite[0], xPos, yPos);					
		
	}


}
