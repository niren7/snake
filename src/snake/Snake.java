package snake;

import java.util.LinkedList;

public class Snake {

	//为以后加速功能准备，同时避免出现魔数
	private int speed = 1;
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}


	private LinkedList<Node> body = new LinkedList<>();
	
	public Node gethead(){
		//蛇肯定是有长度的，使用使用getFirst()应该也是没有问题的，但用peekFirst()更优，养成好习惯。
		return body.peekFirst();
	}
	
	public Node addHead(Node area){
		this.body.addFirst(area);
		return area;
	}
	
	public Node getTail(){
		return body.peekLast();
	}
	
	//返回node的好处？可以返回空吗？
	public Node addTail(Node area){
		this.body.addLast(area);
		return area;
	}
	
	public void deleteTail(){
		this.body.pollLast();
	}
	
	public LinkedList<Node> getBody(){
		return body;
	}
	
	public boolean getFood(Node food){
		Node head = this.gethead();
		if((Math.abs(head.getX()-food.getX()) + Math.abs(head.getY()-food.getY())) == 0){
			return true;
		}
		return false;
	}
	
	public void grow(Node newPart){
		addTail(newPart);
	}
	
	
	public Node move(Direction direction){
		// 根据方向更新贪吃蛇的body
		Node oldTail = this.getTail();
		Node oldHead = this.gethead();
		Node newHead = null;
		switch (direction) {
		case DOWN:
			 newHead = new Node(oldHead.getX(), oldHead.getY() + speed);
			addHead(newHead);
			break;
		case RIGHT:
			 newHead = new Node(oldHead.getX() + speed, oldHead.getY());
			addHead(newHead);
			break;
		case UP:
			 newHead = new Node(oldHead.getX(), oldHead.getY() - speed);
			addHead(newHead);
			break;
		case LEFT:
			newHead = new Node(oldHead.getX() - speed, oldHead.getY());
			addHead(newHead);
			break;
		}
		
		this.deleteTail();
		
		// 返回移动之前的尾部Node
		return oldTail;
	}
	
	
	
}










