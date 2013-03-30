package gameTest;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class GameLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final GameWorld world = new GameWorld();
		final Frame frame = new Frame(world);
        final Timer clockTimer;

        final Action doOneStep = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            	world.tick();
                frame.updateFrame(world);
               // System.out.println("hej");
            }
        };
        clockTimer = new Timer(10, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();
		
	}

}
