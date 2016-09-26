package little.java;

public class Sausage extends PizzaD{
	PizzaD p;
	
	Sausage(PizzaD _p){
		this.p = _p;
	}

	@Override
	PizzaD remA() {
		return new Sausage(p.remA());
	}

	@Override
	PizzaD topAwC() {
		return new Sausage(p.topAwC());
	}

	@Override
	PizzaD subAbC() {
		return new Sausage(p.subAbC());
	}
}
