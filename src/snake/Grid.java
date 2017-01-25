package snake;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

//贪吃蛇的活动范围
public class Grid {

	private final int width;
	private final int height;
	private boolean[][] gridStatus;
	
	private Snake snake;

	private Node food;
	
	//感觉放在Snake类里面会更好
	private Direction oldSnakeDirection = Direction.LEFT;
	private Direction newSnakeDirection;
	
	public Grid(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.newSnakeDirection = oldSnakeDirection;
		
		gridStatus = new boolean[width][height];
		
		for(int i=0;i<width;i++){
			Arrays.fill(gridStatus[i], false);
		}
		
		initSnake();
		createFood();
		
	}
	
	
	public Direction getNewSnakeDirection() {
		return newSnakeDirection;
	}


	public void setNewSnakeDirection(Direction newSnakeDirection) {
		this.newSnakeDirection = newSnakeDirection;
	}


	private void initSnake() {
		
		snake = new Snake();
		
		LinkedList<Node> body = snake.getBody();
		for(int i=0;i<Setting.Default_Snake_Size;i++){
			int x = Setting.Default_Snake_Head_X;
			int y = Setting.Default_Snake_Head_Y;
			Node node = new Node(x+i, y);
			body.addLast(node);
		}
		
		refreshStatus();
	}
	
	private void createFood(){
		
		int x,y;
		Random random = new Random();
		x = random.nextInt(width);
		y = random.nextInt(height);
		
		food = new Node(x, y);
	}
	
	private void refreshStatus(){
		LinkedList<Node> body = snake.getBody();
		
		for(int i=0;i<width;i++){
			Arrays.fill(gridStatus[i], false);
		}
		
		for(Node node : body){
			gridStatus[node.getX()][node.getY()] = true;
		}
	}
	
	public boolean isLive(Snake snake){
		
		//碰到边界
		Node head = snake.gethead();
		if(head.getX() >= width || head.getY() >= height || head.getX() < 0 || head.getY() < 0){
			return false;
		}
		//碰到自己
		if(gridStatus[head.getX()][head.getY()] == true){
			return false;
		}
		
		return true;
	}
	
	public boolean nextRound(){
		
		Node oldTail = snake.move(newSnakeDirection);
		oldSnakeDirection = newSnakeDirection;
		
		if(isLive(snake)){
			if(snake.getFood(food)){
				snake.grow(oldTail);
				createFood();
			}
		}else {
			return false;
		}
		
		refreshStatus();
		
		return true;
	}
	
	public void changeDirection(Direction direction){
		this.oldSnakeDirection = direction;
	}
	
	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Node getFood() {
		return food;
	}

	public void setFood(Node food) {
		this.food = food;
	}

	public Direction getSnakeDirection() {
		return oldSnakeDirection;
	}

	public void setSnakeDirection(Direction snakeDirection) {
		this.oldSnakeDirection = snakeDirection;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}




