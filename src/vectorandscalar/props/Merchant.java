package vectorandscalar.props;

import processing.core.PApplet;
import vectorandscalar.MerchantGUI;
import vectorandscalar.SpriteHandler;

public class Merchant extends Prop{

	public MerchantGUI merchantGUI;
	//From player viewpoint since he clicks on it
	public int woodBuyPrice = 2;
	public int woodSellPrice = 1;
	
	public int stoneBuyPrice = 3;
	public int stoneSellPrice = 1;
	
	public int ironBuyPrice = 10;
	public int ironSellPrice = 5;
	
	public int foodBuyPrice = 2;
	public int foodSellPrice = 1;
	
	public Merchant(PApplet parent, int xPos, int yPos){
		this.parent = parent;
		this.xPos = xPos;
		this.yPos = yPos;
		this.spriteHandler = new SpriteHandler(parent);			
		merchantGUI = new MerchantGUI(parent, this);
		sprite = spriteHandler.loadSpriteNew(136, 72, 151, 87, 1, 2, 2);
		
		
	}
	
	
	public void draw(){		
		
		parent.image(sprite[0], xPos, yPos);
		merchantGUI.draw();
		
	}
	
	


}