package vectorandscalar.props;

import processing.core.PApplet;
import vectorandscalar.SpriteHandler;

public class Mountain extends Prop{

	public Mountain(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);
		
		sprite = spriteHandler.loadSpriteNew(272, 72, 367, 103, 1, 1, 1);	
		
	}
	
	
	
	public void draw(){		
		
		parent.image(sprite[0], xPos, yPos);					
		
	}


}
