package vectorandscalar;

import processing.core.PApplet;
import processing.core.PImage;

public class HP {
	
	//true for player, false for AI
	private boolean PLAYER_HP;
	private PApplet parent;
	private PImage[] sprite;
	private SpriteHandler spriteHandler;
	private int maxHP;
	private int currentHP;
	
	private float xPos;
	private float yPos;


	public HP(PApplet parent, int maxHP, boolean player){
		this.parent = parent;		
		this.spriteHandler = new SpriteHandler(parent);		
		//maxHP = real HP +1 when sprite starts from 0
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		PLAYER_HP = player;
		
		
		if(PLAYER_HP){			
			// 8 + 3 * 8 * 3
			int x1 = 8;
			int x2 = 103;
			int y1 = 144;
			int y2 = 151;				
			
			//sprite = spriteHandler.loadSprite1D(x1, x2, y1, y2, maxHP +1, 2);
			sprite = spriteHandler.loadSprite1D(x1, x2, y1, y2, maxHP +1, 2);
		}
		
		if(!PLAYER_HP){
			sprite = spriteHandler.loadSprite1D(192, 223, 112, 119, maxHP +1, 1);
		}
		
	}
	
	
	
	public void draw(){		
		
		parent.image(sprite[currentHP], xPos, yPos);
						
		
	}
	
	public void setX(float xPos){
		this.xPos = xPos;
	}
	
	public void setY(float yPos){
		this.yPos = yPos;
	}
	
	public void changeHP(int HP){
		this.currentHP += HP;
	}
	
	
	public int getHP(){
		return currentHP;
	}
	
	public void setHP(int HP){
		this.currentHP = HP;
	}
	
	public int getMaxHP(){
		return maxHP;
	}
	
}
