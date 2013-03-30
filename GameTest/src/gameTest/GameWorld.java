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
		blocks.add(new WorldBlock(1300,150,30,100));
		blocks.add(new WorldBlock(300,40,10,500));
		blocks.add(new WorldBlock(300,40,10,175));
		this.width = width;
		this.height = height;
	}
	
	public void reset(){
		player = new Player(35,100,400,300);
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
		player.KeepInsideWorldBorders(0, width);
		notifyObservers();
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
