package little.java;

public class CartesianPt extends Point {
	public CartesianPt(int _x, int _y) {
        super(_x, _y);
	}
	
	@Override
	int distanceToO() {
		return (int) Math.sqrt(Math.pow(y, 2) + Math.pow(y, 2));
	}
	private static <T> void print(T t){
		System.out.println(t);
	}
	
	public static void main(String[] args){
		print(new ManhattanPt(3, 4).colserToO(new ManhattanPt(1, 5)));
	}
}
