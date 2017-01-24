package snake;

public enum Direction {
	
	UP(0),RIGHT(1),DOWN(2),LEFT(3);
	
	private final int value;
	
	public int getValue() {
		return value;
	}

	//个人认为不需要补加上默认的构造函数
	//设计就是要让每个方向都有对应的值从而方便计算，有了限制反而能促进代码规范
	private Direction(int value) {
		this.value = value;
	}
	
}
