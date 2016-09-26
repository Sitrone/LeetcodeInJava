package little.java.chapter4;

public class TopAwCV {
    PizzaD forCrust() {
        return new Crust();
    }
    PizzaD forCheese(PizzaD p) {
        return new Cheese(p.topAwC());
    }
    PizzaD forOlive(PizzaD p) {
        return new Olive(p.topAwC());
    }
    PizzaD forAnchovy(PizzaD p) {
        return new Cheese(new Anchovy(p.topAwC()));
    }
    PizzaD forSausage(PizzaD p) {
        return new Sausage(p.topAwC());
    }
}
