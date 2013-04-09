package gameTest;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
	
	final Action reset = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            world.reset();
        	System.out.println("reset");
        }
	};
	
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
    
    final Action rightStop = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
        	if(world.getPlayer().getStatusX() != StatusX.LEFTHOLD){
        		world.getPlayer().rightStop();
        	}
        }
    };

    final Action left = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
        	world.getPlayer().moveLeft();
        }
    };

    final Action leftStop = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
        	if(world.getPlayer().getStatusX() != StatusX.RIGHTHOLD){
        		world.getPlayer().leftStop();
        	}
        }
    };
    
    final Action down = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
        	world.getPlayer().moveDown();
        }
    };
    

	private GameWorld world;
	private GraphicalViewer paintedArea;
	private GameState gameState;
	
	public Frame(GameWorld world) {
        super("GameTest");
        createMenu();
        paintedArea = new GraphicalViewer(world); 
        
        paintedArea.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("UP"), "up");
        paintedArea.getActionMap().put("up", up);
      
        paintedArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("Q"), "reset");
        paintedArea.getActionMap().put("reset", reset);

        paintedArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down");
        paintedArea.getActionMap().put("down", down);

        paintedArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right");
        paintedArea.getActionMap().put("right", right);
        
        paintedArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released RIGHT"), "rightReleased");
        paintedArea.getActionMap().put("rightReleased", rightStop);

        paintedArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
        paintedArea.getActionMap().put("left", left);
        
        paintedArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released LEFT"), "leftReleased");
        paintedArea.getActionMap().put("leftReleased", leftStop);
        
        
        this.setSize(world.getWidth(),world.getHeight());
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
                world.reset();
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
