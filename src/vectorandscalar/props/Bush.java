package vectorandscalar.props;

import processing.core.PApplet;
import vectorandscalar.SpriteHandler;

public class Bush extends Prop{

	public Bush(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);	
		variation = (int) parent.random(3);
		
		sprite = spriteHandler.loadSpriteNew(8, 88, 55, 95, 3, 2, 1);
		
		
	}
	
	
	public void draw(){		
		
		parent.image(sprite[variation], xPos, yPos);
		
	}


}