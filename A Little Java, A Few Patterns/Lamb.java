package little.java;

public class Lamb extends ShishD{
	ShishD s;
	
	public Lamb(ShishD _s) {
		this.s = _s;
	}

	@Override
	boolean onlyOnions() {
		return false;
	}

	@Override
	boolean isVegetarian() {
		return false;
	}
}
