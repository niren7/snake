package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GameView {

	private Grid grid;
	
	public GameView(Grid grid) {
		super();
		this.grid = grid;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public void draw(Graphics graphics){
		drawGridBackGround(graphics);
		drawSnake(graphics,grid.getSnake());
		drawFood(graphics,grid.getFood());
	}
	
	private void drawSquare(Graphics graphics,Node squareArea,Color color){
		graphics.setColor(color);
		int size = Setting.Default_Node_Size;
		graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size, size, size);
	}
	
	private void drawCircle(Graphics graphics,Node squareArea,Color color){
		graphics.setColor(color);
		int size = Setting.Default_Node_Size;
		graphics.fillOval(squareArea.getX() * size, squareArea.getY() * size, size, size);
	}
	
	private void drawSnake(Graphics graphics, Snake snake) {
		for(Node node: snake.getBody()){
			drawSquare(graphics, node, Color.BLUE);
		}
	}

	private void drawFood(Graphics graphics, Node food) {
		int color = new Random().nextInt(3);
		switch (color) {
		case 0:
			drawCircle(graphics, food, Color.RED);
			break;
		case 1:
			drawCircle(graphics, food, Color.YELLOW);
			break;
		case 2:
			drawCircle(graphics, food, Color.GREEN);
			break;
		}
	}

	public void drawGridBackGround(Graphics graphics){
		int size = Setting.Default_Node_Size;
		for(int i=0;i<50;i++){
			graphics.drawLine(0, i * size, grid.getWidth() * size, i * size);
			graphics.drawLine(i * size, 0, i * size, grid.getHeight() * size);
		}
		graphics.fillRect(0, 0, grid.getWidth() * size, grid.getHeight() * size);
	}
	
	private JPanel canvas;
	
	public void init(){
		canvas = new JPanel(){
			@Override
			public void paintComponent(Graphics graphics) {
				drawGridBackGround(graphics);
				drawSnake(graphics, grid.getSnake());
				drawFood(graphics, grid.getFood());
			}
		};
	}
	
	public void draw(){
		canvas.repaint();
	}
	
	public JPanel getCanvas(){
		return canvas;
	}
	
}
