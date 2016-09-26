package little.java.chapter4;

class Olive extends PizzaD { //éÏé­
    PizzaD p;
    Olive(PizzaD _p) {
        p = _p;
    }
    PizzaD remA() {
        return remFn.forOlive(p);
    }
    PizzaD topAwC() {
        return topFn.forOlive(p);
    }
    PizzaD subAbC() {
        return subFn.forOlive(p);
    }
}