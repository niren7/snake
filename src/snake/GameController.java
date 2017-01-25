package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class GameController implements KeyListener,Runnable {
	
	private Grid grid;
	private GameView gameView;
	
	private boolean living;
	
	public GameController(Grid grid,GameView gameView) {
		super();
		this.grid = grid;
		this.gameView = gameView;
		this.living = true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		Direction oldDirection = grid.getSnakeDirection();
		
		if(keyCode == KeyEvent.VK_UP && oldDirection != Direction.DOWN){
			grid.setNewSnakeDirection(Direction.UP);
		}else if(keyCode == KeyEvent.VK_DOWN && oldDirection != Direction.UP){
			grid.setNewSnakeDirection(Direction.DOWN);
		}else if(keyCode == KeyEvent.VK_LEFT && oldDirection != Direction.RIGHT){
			grid.setNewSnakeDirection(Direction.LEFT);
		}else if(keyCode == KeyEvent.VK_RIGHT && oldDirection != Direction.LEFT){
			grid.setNewSnakeDirection(Direction.RIGHT);
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		
		while(living){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
			
			living = grid.nextRound();
			
			if(living == false){
				JOptionPane.showMessageDialog(null, "Game over!");
				break;
			}
			
			gameView.draw();
			
		}
		
	}

}
