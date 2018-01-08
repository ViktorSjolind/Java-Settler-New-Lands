package vectorandscalar;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import vectorandscalar.animals.Player;
import vectorandscalar.props.Merchant;

public class MerchantGUI {
	private PApplet parent;
	private PImage[] sprite;
	private SpriteHandler spriteHandler;
	private PFont font;	
	public float xPos;
	public float yPos;
	private Merchant merchant;
	
	public float square1X = xPos+11;
	public float square1Y = yPos+7;	
	public float square2X = xPos+17;
	public float square2Y = yPos+7;	
	
	public float square3X = xPos+11;
	public float square3Y = yPos+12;	
	public float square4X = xPos+17;
	public float square4Y = yPos+12;	
	
	public float square5X = xPos+11;
	public float square5Y = yPos+17;	
	public float square6X = xPos+17;
	public float square6Y = yPos+17;	
	
	public float square7X = xPos+11;
	public float square7Y = yPos+22;	
	public float square8X = xPos+17;
	public float square8Y = yPos+22;
	

	public MerchantGUI(PApplet parent, Merchant merchant){
		this.parent = parent;	
		this.merchant = merchant;
		this.spriteHandler = new SpriteHandler(parent);		
		sprite = spriteHandler.loadSpriteNew(152, 64, 175, 87, 1, 3, 3);
		loadFont();
		
		xPos = merchant.getX() + 20;
		yPos = 6;
		
		
		square1X = xPos+11;
		square1Y = yPos+7;	
		square2X = xPos+17;
		square2Y = yPos+7;	
		
		square3X = xPos+11;
		square3Y = yPos+12;	
		square4X = xPos+17;
		square4Y = yPos+12;	
		
		square5X = xPos+11;
		square5Y = yPos+17;	
		square6X = xPos+17;
		square6Y = yPos+17;	
		
		square7X = xPos+11;
		square7Y = yPos+22;	
		square8X = xPos+17;
		square8Y = yPos+22;
		
	}
	
	private void loadFont() {
		font = parent.createFont("Asar-Regular.ttf", 2);
		parent.textFont(font);
	}
	
	public void draw(){		
		
		
		parent.image(sprite[0], xPos, yPos);				
					
		
		parent.fill(255,255,255);
		parent.text("Merchant", xPos + 8, yPos - 2);
		
		parent.text("Buy", xPos + 10, yPos + 3);		
		parent.text("Sell", xPos + 16, yPos+3);
		
		//wood
		parent.text(merchant.woodBuyPrice, square1X, square1Y);		
		parent.text(merchant.woodSellPrice, square2X, square2Y);
		
		//stone
		parent.text(merchant.stoneBuyPrice, square3X, square3Y);		
		parent.text(merchant.stoneSellPrice, square4X, square4Y);
		
		//iron
		parent.text(merchant.ironBuyPrice, square5X, square5Y);		
		parent.text(merchant.ironSellPrice, square6X, square6Y);	//y = 16
		
		//food
		parent.text(merchant.foodBuyPrice, square7X, square7Y);		
		parent.text(merchant.foodSellPrice, square8X, square8Y);
		
		

	}
	
	public void setX(float xPos){
		this.xPos = xPos;
	}
	
	public void setY(float yPos){
		this.yPos = yPos;
	}
}