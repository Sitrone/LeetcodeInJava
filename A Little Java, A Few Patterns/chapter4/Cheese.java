package little.java.chapter4;

class Cheese extends PizzaD { //����
    PizzaD p;
    Cheese(PizzaD _p) {
        p = _p;
    }
    PizzaD remA() {
        return remFn.forCheese(p);
    }
    PizzaD topAwC() {
        return topFn.forCheese(p);
    }
    PizzaD subAbC() {
        return subFn.forCheese(p);
    }

}