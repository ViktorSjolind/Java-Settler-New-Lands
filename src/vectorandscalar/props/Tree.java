package vectorandscalar.props;
import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.SpriteHandler;

public class Tree extends Prop {
	

	public Tree(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		variation = (int) parent.random(4);
		spriteHandler = new SpriteHandler(parent);				
		sprite = spriteHandler.loadSpriteNew(8, 120, 103, 143, 4, 3, 3);
		
		
	}	
	
	public void draw(){
		
		parent.image(sprite[variation], xPos, yPos);
		
	}	
}
