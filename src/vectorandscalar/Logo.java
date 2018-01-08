package vectorandscalar;

import processing.core.PApplet;
import processing.core.PImage;

public class Logo {
	
	private PApplet parent;
	private PImage logoImage;
	private int xPos;
	private int yPos;

	public Logo(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		logoImage = parent.loadImage("VectorAndScalarLogo.png");
		
	}
	
	
	
	public void draw(){
		parent.image(logoImage, xPos, yPos);	
	}
	
	
}
