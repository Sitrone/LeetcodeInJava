package little.java.chapter4;

public class SubAbCV {
    PizzaD forCrust() {
        return new Crust();
    }
    PizzaD forCheese(PizzaD p) {
        return new Cheese(p.subAbC());
    }
    PizzaD forOlive(PizzaD p) {
        return new Olive(p.subAbC());
    }
    PizzaD forAnchovy(PizzaD p) {
        return new Cheese(p.subAbC());
    }
    PizzaD forSausage(PizzaD p) {
        return new Sausage(p.subAbC());
    }
}
