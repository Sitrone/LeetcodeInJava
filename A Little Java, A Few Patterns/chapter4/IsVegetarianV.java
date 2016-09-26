package little.java.chapter4;


public class IsVegetarianV {
    boolean forSkewer() {
        return true;
    }
    boolean forOnion(ShishD s) {
        return s.isVegetarian();
    }
    boolean forLamb(ShishD s) {
        return false;
    }
    boolean forTomato(ShishD s) {
        return s.isVegetarian();
    }
}
