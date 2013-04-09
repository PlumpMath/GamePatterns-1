/**
 * 
 */
package gameTest;

import java.util.ArrayList;


/**
 * @author Myggan
 *
 */
public class GameWorld implements Observable {
	final private int width, height;
	
	private ArrayList<Observer> observers;
	private Player player;
	private ArrayList<WorldBlock> blocks;
	
	public GameWorld(int width, int height){
		player = new Player(35,100,400,300);
		observers = new ArrayList<Observer>();
		blocks = new ArrayList<WorldBlock>();
		blocks.add(new WorldBlock(2400,150,30,100));
		blocks.add(new WorldBlock(300,40,10,500));
		blocks.add(new WorldBlock(300,40,10,175));
		blocks.add(new WorldBlock(300,40,500,500));
		blocks.add(new WorldBlock(300,40,700,175));
		blocks.add(new WorldBlock(300,40,1500,500));
		blocks.add(new WorldBlock(300,40,2100,175));
		this.width = width;
		this.height = height;
	}
	
	public void reset(){
		player = new Player(35,100,400,300);
		blocks = new ArrayList<WorldBlock>();
		blocks.add(new WorldBlock(2400,150,30,100));
		blocks.add(new WorldBlock(300,40,10,500));
		blocks.add(new WorldBlock(300,40,10,175));
		blocks.add(new WorldBlock(300,40,500,500));
		blocks.add(new WorldBlock(300,40,700,175));
		blocks.add(new WorldBlock(300,40,1500,500));
		blocks.add(new WorldBlock(300,40,2100,175));
		//block = new WorldBlock(1200, 100, 10, 100);
	}
	public Player getPlayer(){
		return player;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public ArrayList<WorldBlock> getBlocks(){
		return blocks;
	}
	
	
	public void tick(){
		for( WorldBlock block : blocks){
			player.handleMovingWorldObject(block);
		}
		/*player.KeepInsideWorldBorders(0, width);*/
		keepPlayerInWorld();
		notifyObservers();
	}
	
	private void keepPlayerInWorld(){
		//checks so the player doesn't move outside the border to the left
		if(player.position.x <= 0){
			player.velocity.x = player.acceleration.x = 0;
			player.position.x = 0;
		}
		//Makes the Game World move along with the player
		else if (player.position.x >= width/16*9){
			//System.out.println("test");
			for(WorldBlock block : blocks){
				block.setXCoord((int)block.getXCoord()-(int)(player.position.x - width/16*9));
			}
			player.setXCoord((int)player.getXCoord()-(int)(player.position.x - width/16*9));
		}
	}
	
	@Override
	public void addObserver(Observer observer) {
		if(observer != null){
			observers.add(observer);
		}
	}

	@Override
	public void deleteObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if (i >= 0){
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		if (observers != null) {
            for (Observer observer : observers) {
                observer.observableChanged();
            }
        }
	}

}
