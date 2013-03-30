package gameTest;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
	
	final Action up = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
        	world.getPlayer().moveUp();
        }
    };

    final Action right = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
        	world.getPlayer().moveRight();
        }
    };

    final Action left = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
        	world.getPlayer().moveLeft();
        }
    };

    final Action down = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
        	world.getPlayer().moveDown();
        }
    };

	GameWorld world = new GameWorld();
	GraphicalViewer paintedArea;
	
	public Frame(GameWorld world) {
        super("GameTest");
        createMenu();
        paintedArea = new GraphicalViewer(world); 
        
        paintedArea.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("UP"), "up");
        paintedArea.getActionMap().put("up", up);
      
/*        paintedArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "superjump");
        paintedArea.getActionMap().put("superjump", inget);*/

        paintedArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down");
        paintedArea.getActionMap().put("down", down);

        paintedArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right");
        paintedArea.getActionMap().put("right", right);

        paintedArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
        paintedArea.getActionMap().put("left", left);
        
        this.setSize(800,600);
        world.addObserver(paintedArea);
        this.add(paintedArea);
        //this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void updateFrame(GameWorld world) {
		this.world = world;
		paintedArea.insertNewGameWorld(this.world);
        this.setVisible(true);
		
	}

	private void createMenu() {
        final JMenuBar menuBar = new JMenuBar();

        final JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenuItem restartActionItem = new JMenuItem("Restart");
        JMenuItem exitActionItem = new JMenuItem("Exit");
        gameMenu.add(restartActionItem);
        gameMenu.addSeparator();
        gameMenu.add(exitActionItem);

        setJMenuBar(menuBar);

        // Listeners for the menu buttons
        restartActionItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //board.reset();
            	System.out.println("reset");
            }
        }
        );
        exitActionItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(DISPOSE_ON_CLOSE);
            }
        }
        );
    }

}
