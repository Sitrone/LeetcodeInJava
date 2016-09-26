package little.java;

public class Anchovy extends PizzaD{
	PizzaD p;
	
	Anchovy(PizzaD _p){
		this.p = _p;
	}

	@Override
	PizzaD remA() {
		return p.remA();
	}

	@Override
	PizzaD topAwC() {
		return new Cheese(new Anchovy(p.topAwC()));
	}

	@Override
	PizzaD subAbC() {
		return new Cheese(p.subAbC());
	}
	
	public static void main(String[] args){
		System.out.println(new Cheese(
							new Anchovy(
							  new Anchovy(
							    new Crust()))).remA());
	}
}
