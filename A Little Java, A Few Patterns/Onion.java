package little.java;

public class Onion extends ShishD {
	ShishD s;
	
	public Onion(ShishD _s) {
		this.s = _s;
	}

	@Override
	boolean onlyOnions() {
		return s.onlyOnions();
	}

	@Override
	boolean isVegetarian() {
		return s.isVegetarian();
	}
}
