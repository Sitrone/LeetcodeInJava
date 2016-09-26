package little.java.chapter4;

class Lamb extends ShishD { //∏·—Ú»‚
    ShishD s;
    Lamb (ShishD _s) {
        s = _s;
    }

    @Override
    boolean isVegetarian() {
        return ivFn.forLamb(s);
    }
	@Override
	boolean onlyOnions() {
		return ooFn.forLamb(s);
	}
}
