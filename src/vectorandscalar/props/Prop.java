package vectorandscalar.props;

import processing.core.*;
import vectorandscalar.SpriteHandler;

public abstract class Prop {
	
	protected PApplet parent;
	protected PImage[] sprite;
	protected SpriteHandler spriteHandler;
	protected int xPos;
	protected int yPos;
	protected int variation;
	
	public abstract void draw();
	
	public float getX() {		
		return xPos;
	}
	
}
