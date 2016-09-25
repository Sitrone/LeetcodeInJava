package little.java;

public abstract class Point {
	int x, y;
	Point(int _x, int _y){
		this.x = _x;
		this.y = _y;
	}
	
	abstract int distanceToO();
	boolean colserToO(Point p){
		return distanceToO() <= p.distanceToO();
	}
}
