package little.java.chapter4;

class Sausage extends PizzaD { //œ„≥¶
    PizzaD p;
    Sausage(PizzaD _p) {
        p = _p;
    }
    PizzaD remA() {
        return remFn.forSausage(p);
    }
    PizzaD topAwC() {
        return topFn.forSausage(p);
    }
    PizzaD subAbC() {
        return subFn.forSausage(p);
    }
}
