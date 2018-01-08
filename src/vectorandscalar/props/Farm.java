package vectorandscalar.props;

import processing.core.PApplet;
import vectorandscalar.SpriteHandler;

public class Farm extends Prop{

	public Farm(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);	
		variation = (int) parent.random(3);
		
		sprite = spriteHandler.loadSpriteNew(8, 80, 31, 87, 3, 1, 1);
		
		
	}
	
	
	public void draw(){		
		
		parent.image(sprite[variation], xPos, yPos);
		
	}


}