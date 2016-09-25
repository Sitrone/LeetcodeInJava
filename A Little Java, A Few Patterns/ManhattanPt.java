package little.java;

public class ManhattanPt extends Point{
	public ManhattanPt(int _x, int _y) {
		super(_x, _y);
	}

	@Override
	int distanceToO() {
		return x + y;
	}
	
}
