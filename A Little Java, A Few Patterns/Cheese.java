package little.java;

public class Cheese extends PizzaD{
	PizzaD p;
	
	Cheese(PizzaD _p){
		this.p = _p;
	}

	@Override
	PizzaD remA() {
		return new Cheese(p.remA());
	}

	@Override
	PizzaD topAwC() {
		return new Cheese(p.topAwC());
	}

	@Override
	PizzaD subAbC() {
		return new Cheese(p.subAbC());
	}
}
