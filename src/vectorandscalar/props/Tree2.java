package vectorandscalar.props;
import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.SpriteHandler;

public class Tree2 extends Prop {	
	
	public Tree2(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		spriteHandler = new SpriteHandler(parent);
		variation = (int) parent.random(5);						
		sprite = spriteHandler.loadSpriteNew(16, 248, 55, 279, 5, 1, 4);		
	}
	
	
	public void draw(){				
		parent.image(sprite[variation], xPos, yPos);			
	}
	
}
