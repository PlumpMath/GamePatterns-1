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
	ArrayList<Observer> observers;
	Player player;
	WorldBlock block;
	
	public GameWorld(){
		player = new Player(50,100,400,300);
		observers = new ArrayList<Observer>();
		block = new WorldBlock(600, 100, 10, 100);
	}
	public Player getPlayer(){
		return player;
	}
	public WorldBlock getBlock(){
		return block;
	}
	
	
	public void tick(){
		player.handleMovingWorldObject(block);
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
