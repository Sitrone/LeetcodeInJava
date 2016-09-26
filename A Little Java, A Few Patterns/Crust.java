package little.java;

public class Crust extends PizzaD{

	@Override
	PizzaD remA() {
		return new Crust();
	}

	@Override
	PizzaD topAwC() {
		return new Crust();
	}

	@Override
	PizzaD subAbC() {
		return new Crust();
	}
}
