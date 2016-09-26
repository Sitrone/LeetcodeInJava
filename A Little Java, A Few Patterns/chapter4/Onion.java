package little.java.chapter4;

class Onion extends ShishD { //бѓДа
    ShishD s;
    Onion (ShishD _s) {
        s = _s;
    }
    boolean onlyOnions() {
        return ooFn.forOnion(s);
    }
    boolean isVegetarian() {
        return ivFn.forOnion(s);
    }
}
