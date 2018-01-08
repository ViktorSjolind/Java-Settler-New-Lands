package vectorandscalar;

import processing.core.PApplet;
import processing.core.PImage;

public class SpriteHandler {
	
	private PApplet parent;
	public static final int SPRITE_SIZE = 8;
	public static final int TILE_SIZE = 8;
	private PImage[] sprite;
	PImage spriteSheet;
	
	public SpriteHandler(PApplet parent){
		this.parent = parent;
		spriteSheet = parent.loadImage("8x8SpriteSheet.png");
	}
	
	
	public PImage[] loadSprite(int startX, int endX, int startY, int endY, int noSprites){		
		//PImage spriteSheet = parent.loadImage("8x8SpriteSheet.png");
		sprite = new PImage[noSprites];
		int counter = 0;
		
		for(int y = startY; y < endY; y+= SPRITE_SIZE){
			for(int x  = startX; x < endX; x+= SPRITE_SIZE){
				sprite[counter] = spriteSheet.get(x, y, SPRITE_SIZE, SPRITE_SIZE);			
				counter++;
				
			}			
		}		
		
		return sprite;
		
	}
	
	
	//for loading sprites that are y = 1 and x * N, N = xPower
	public PImage[] loadSprite1D(int startX, int endX, int startY, int endY, int noSprites, int xPower){		
		//PImage spriteSheet = parent.loadImage("8x8SpriteSheet.png");
		sprite = new PImage[noSprites];
		int counter = 0;		
		//System.out.println("c x1 y1 w h");
		for(int x  = startX; x < endX; x+= (SPRITE_SIZE * xPower)){
			//System.out.println(counter + " " + x + " " + startY + " " + (SPRITE_SIZE * xPower) + " " + SPRITE_SIZE);
			
			sprite[counter] = spriteSheet.get(x, startY, SPRITE_SIZE * xPower, SPRITE_SIZE);			
			counter++;
			
		}			
				
		
		return sprite;
		
	}
	
	//for loading sprites that are y = N and x = 1	
	public PImage[] loadSprite1DTall(int startX, int endX, int startY, int endY, int noSprites, int yPower){		
		PImage spriteSheet = parent.loadImage("8x8SpriteSheet.png");
		sprite = new PImage[noSprites];
		int counter = 0;		
		//PImage spriteSheet = parent.loadImage("8x8SpriteSheet.png");
		
		for(int x  = startX; x < endX; x+= (SPRITE_SIZE)){				
			sprite[counter] = spriteSheet.get(x, startY, SPRITE_SIZE, SPRITE_SIZE * yPower);			
			counter++;
			
		}			
				
		
		return sprite;
		
	}
	
	/**
	load in all variations/animation
	spriteW/spriteH = the size of one subimage
	sprite = one subimage
	
	spriteW = how many tiles wide
	spriteH = how many tiles tall
	*/
	//System.out.println("x: " + x + " y: " + y + " w: " + spriteW * TILE_SIZE  + " h: " + (spriteH * TILE_SIZE));
	//16,248	55,279	1	4
	public PImage[] loadSpriteNew(int x1, int y1, int x2, int y2, int arrayLength, int spriteW,int spriteH){
		sprite = new PImage[arrayLength];
		int id = 0;		
		
		for(int y = y1; y < y2; y += (spriteH * TILE_SIZE)){
			for(int x = x1; x < x2; x+= (spriteW * TILE_SIZE)){
				
				sprite[id] = spriteSheet.get(x, y, (spriteW * TILE_SIZE), (spriteH * TILE_SIZE));
				id++;
			}
		}
		
		
		return sprite;
		
	}
	
	
	
	
	
	
	
	
}
