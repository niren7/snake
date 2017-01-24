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
		
		if(keyCode == KeyEvent.VK_UP && grid.getSnakeDirection() != Direction.DOWN){
			grid.changeDirection(Direction.UP);
		}else if(keyCode == KeyEvent.VK_DOWN && grid.getSnakeDirection() != Direction.UP){
			grid.changeDirection(Direction.DOWN);
		}else if(keyCode == KeyEvent.VK_LEFT && grid.getSnakeDirection() != Direction.RIGHT){
			grid.changeDirection(Direction.LEFT);
		}else if(keyCode == KeyEvent.VK_RIGHT && grid.getSnakeDirection() != Direction.LEFT){
			grid.changeDirection(Direction.RIGHT);
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
