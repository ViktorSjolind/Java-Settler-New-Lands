package vectorandscalar;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import vectorandscalar.animals.Player;

public class GUI {
	private PApplet parent;
	private PImage[] sprite;
	private SpriteHandler spriteHandler;
	private PFont font;
	
	private float xPos;
	private float yPos;
	private Player player;

	public GUI(PApplet parent, Player player){
		this.parent = parent;	
		this.player = player;
		this.spriteHandler = new SpriteHandler(parent);		
		sprite = spriteHandler.loadSprite(96, 127, 88, 103, 8);
		loadFont();
	}
	
	private void loadFont() {
		font = parent.createFont("Asar-Regular.ttf", 2);
		parent.textFont(font);
	}
	
	public void draw(){		
		
		int counter = 0;
		for(int y = 0; y < 2; y++){
			for(int x = 0; x < 4; x++){
				parent.image(sprite[counter], xPos + (x * spriteHandler.SPRITE_SIZE), yPos + (y * spriteHandler.SPRITE_SIZE));				
				counter++;
			}
		}				
		
		parent.fill(255,255,255);
		parent.text(player.getMoney(), xPos+7, yPos+5);
		parent.text(player.getWood(), xPos+7, yPos+11);
		
		parent.text(player.getStone(), xPos+18, yPos+5);
		parent.text(player.getIron(), xPos+18, yPos+11);		
		
		parent.text(player.getFood(), xPos+28, yPos+5);
		
	}
	
	public void setX(float xPos){
		this.xPos = xPos;
	}
	
	public void setY(float yPos){
		this.yPos = yPos;
	}
}
