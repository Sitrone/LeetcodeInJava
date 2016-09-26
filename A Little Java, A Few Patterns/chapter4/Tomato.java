package little.java.chapter4;

public class Tomato extends ShishD { //Î÷ºìÊÁ
    ShishD s;
    Tomato (ShishD _s) {
        s = _s;
    }
    @Override
    boolean isVegetarian() {
        return ivFn.forTomato(s);
    }
	@Override
	boolean onlyOnions() {
		return ooFn.forTomato(s);
	}
}
