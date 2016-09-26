package little.java.chapter4;

class Anchovy extends PizzaD { //∑ÔŒ≤”„
    PizzaD p;
    Anchovy(PizzaD _p) {
        p = _p;
    }
    PizzaD remA() {
        return remFn.forAnchovy(p);
    }
    PizzaD topAwC() {
        return topFn.forAnchovy(p);
    }
    PizzaD subAbC() {
        return subFn.forAnchovy(p);
    }
}