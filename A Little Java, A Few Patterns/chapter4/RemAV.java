package little.java.chapter4;

public class RemAV {
    PizzaD forCrust() {
        return new Crust();
    }
    PizzaD forCheese(PizzaD p) {
        return new Cheese(p.remA());
    }
    PizzaD forOlive(PizzaD p) {
        return new Olive(p.remA());
    }
    PizzaD forAnchovy(PizzaD p) {
        return p.remA();
    }
    PizzaD forSausage(PizzaD p) {
        return new Sausage(p.remA());
    }
}
