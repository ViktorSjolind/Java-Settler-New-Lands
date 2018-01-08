package vectorandscalar.props;

import processing.core.PApplet;
import vectorandscalar.SpriteHandler;

public class Bush2 extends Prop{

	public Bush2(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);		
		
		sprite = spriteHandler.loadSpriteNew(176, 272, 191, 279, 1, 2, 1);
		
		
	}
	
	
	public void draw(){		
		
		parent.image(sprite[0], xPos, yPos);
		
	}


}