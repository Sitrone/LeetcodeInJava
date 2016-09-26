package little.java;

public class Olive extends PizzaD{
	PizzaD p;
	
	Olive(PizzaD _p){
		this.p = _p;
	}

	@Override
	PizzaD remA() {
		return new Olive(p.remA());
	}

	@Override
	PizzaD topAwC() {
		return new Olive(p.topAwC());
	}

	@Override
	PizzaD subAbC() {
		return new Olive(p.subAbC());
	}
	
}
