package snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;


public class SnakeApp {

	private GameView gameView;
	private GameController gameController;
	
	public void init(){
		
		Grid grid = new Grid(Setting.Default_Grid_Width,Setting.Default_Grid_Height);
		
		JFrame window = new JFrame("贪吃蛇");
		
		Container contentPane = window.getContentPane();
		
		gameView = new GameView(grid);
		gameView.init();
		
		//为什么不是50
		gameView.getCanvas().setPreferredSize(new Dimension(snake.Setting.Default_Node_Size * 49,snake.Setting.Default_Node_Size * 49));
		
		contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);
		
		gameController = new GameController(grid,gameView);
		window.addKeyListener(gameController);
		
		new Thread(gameController).start();
		
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		SnakeApp snakeApp = new SnakeApp();
		snakeApp.init();
		
	}
}
