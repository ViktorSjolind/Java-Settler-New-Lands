package vectorandscalar.props;

import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.SpriteHandler;

public class House extends Prop{
	
	
	
	public House(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);		
		variation = (int)parent.random(3);		
		
		sprite = spriteHandler.loadSpriteNew(8, 152, 103, 167, 3, 4, 2);		
		
	}
	
	
	public void draw(){
		
		parent.image(sprite[variation], xPos, yPos);
		
	}
	
}
