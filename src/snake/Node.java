package snake;

//蛇的身体节点
public class Node {

	//教程上建议用final修饰，为什么？
	//蛇的身子节点确定后就不应该再变了，同时使用final
	private final int x;
	private final int y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
