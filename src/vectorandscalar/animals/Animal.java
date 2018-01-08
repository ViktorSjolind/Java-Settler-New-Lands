package vectorandscalar.animals;

import processing.core.PApplet;
import processing.core.PImage;
import vectorandscalar.HP;
import vectorandscalar.MainSettlers;
import vectorandscalar.SpriteHandler;

public abstract class Animal {
	
	//Variables that need to be set on initialization
	protected PApplet parent;
	protected PImage[] sprite;
	protected SpriteHandler spriteHandler;
	protected float xPos;
	protected float yPos;
	protected float speed;
	protected int direction;
	public HP hp;	
	
	//Variables for random behavior
	private int timeLast;
	private int timePassed;
	private int delay;
	
	
	
	
	public abstract void update();
	
	public abstract void draw();
	
	
	/**
	 Basic wandering AI
	*/
	public void animalAIMovement(){
		timePassed = parent.millis() - timeLast;	
		
		if(parent.millis() > (timeLast + delay)){		
			//System.out.println("timeLast + delay: " + (timeLast + delay) + " delay: " + delay );
			timeLast = parent.millis();			
			direction = direction * (-1);				
			setDelay();
		}
	}
	
	
	
	
	
	/**
	 Sets the delay between actions
	 */
	public void setDelay(){
		delay = (int) parent.random(3000, 6000);
		
	}		
	
	/**
	 inc/dec HP by input e.g. 1 or -1
	 */
	public void changeHP(int num){		
		//System.out.println(this.getClass() + "current hp: " + hp.getHP()  + " change by: " + num);
		
		if((num < 0  && hp.getHP() + num >= 0) || (num > 0 && (hp.getHP() + num) <= hp.getMaxHP()  )){
			hp.changeHP(num);
		}		
	}
	
	/**
	 True if dead, False if alive
	 */
	public boolean isDead() {
		if(hp.getHP() <= 0){
			return true;
		}else{
			return false;
		}
		
	}	
	
	//Movement getters
	public float getSpeed(){
		return speed;
	}
	
	public float getX(){
		return xPos;
	}
	
	public float getY(){
		return yPos;
	}
	
	public int getDirection(){
		return direction;
	}
	
}























