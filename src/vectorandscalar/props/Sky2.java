package vectorandscalar.props;
import processing.core.PApplet;
import vectorandscalar.SpriteHandler;


public class Sky2 extends Prop{
		
	public Sky2(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);
		
		sprite = spriteHandler.loadSpriteNew(120, 248, 127, 255, 1, 1, 1);	
		
	}
	
	
	
	public void draw(){		
		
		parent.image(sprite[0], xPos, yPos);					
		
	}
}
