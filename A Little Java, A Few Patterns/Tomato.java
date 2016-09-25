package little.java;

public class Tomato extends ShishD{
	ShishD s;
	
	public Tomato(ShishD _s) {
		this.s = _s;
	}

	@Override
	boolean onlyOnions() {
		return false;
	}
	
	@Override
	boolean isVegetarian() {
		return s.isVegetarian();
	}
	
	private static <T> void print(T t){
		System.out.println(t);
	}
	public static void main(String[] args){
		print(new Onion(new Onion(new Skewer())).onlyOnions());
		print((new Onion(new Skewer())).onlyOnions());
	}


}
