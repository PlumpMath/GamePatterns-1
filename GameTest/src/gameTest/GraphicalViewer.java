/**
 * 
 */
package gameTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * @author Myggan
 *
 */
public class GraphicalViewer extends JComponent implements Observer{
	GameWorld world;
	public GraphicalViewer(GameWorld gameWorld){
		this.world = gameWorld;
	}
	public void insertNewGameWorld(GameWorld world){
		this.world = world;
	}
	@Override
	public void observableChanged() {
		repaint();
	}
	
	public void paintComponent(final Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //paintBackground(g2);
        paintPlayer(g2);
        paintBlock(g2);
    }
	private void paintBackground(Graphics2D g2) {
        final Area background = new Area(new Rectangle2D.Float(
                0, 0, 800, 600));
        g2.setPaint(new Color(0, 100, 30));
        g2.fill(background);
        final Area floorArea = new Area(new Rectangle2D.Float(
                0, 400, 300, 20));
        g2.setPaint(new Color(0, 0, 255));
        g2.fill(floorArea);
    }
	private void paintPlayer(Graphics2D g2){
//		System.out.println(world.getPlayer().getYCoord());
		final Area player = new Area( new Rectangle2D.Float((int)world.getPlayer().getXCoord(),600-(int)world.getPlayer().getYCoord(),
				world.getPlayer().getWidth(),world.getPlayer().getHeight()));
		g2.setPaint(new Color(100,30,50));
		g2.fill(player);
	}
	private void paintBlock(Graphics2D g2){
		//System.out.println(world.getBlock().getXCoord());
		for(WorldBlock block : world.getBlocks()){
		final Area blockArea = new Area(new Rectangle2D.Float(
                (int)block.getXCoord(), 600-(int)block.getYCoord(),
                	block.getWidth(), block.getHeight()));
        g2.setPaint(new Color(0, 100, 30));
        g2.fill(blockArea);
		}
	}
	
}
