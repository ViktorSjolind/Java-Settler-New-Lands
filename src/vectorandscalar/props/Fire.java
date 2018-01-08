package vectorandscalar.props;

import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.SpriteHandler;

public class Fire extends Prop{

	public Fire(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);		
		
		sprite = spriteHandler.loadSpriteNew(72, 88, 95, 95, 3, 1, 1);
		
		
	}
	
	
	public void draw(){		
		
		parent.image(sprite[parent.frameCount/10 % sprite.length], xPos, yPos);
		
	}


}
