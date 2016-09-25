package little.java;

public class Zucchini extends Kebab{
	Kebab k;

	Zucchini(Kebab _k){
		this.k = _k;
	}
	@Override
	boolean isVeggie() {
		return k.isVeggie();
	}

	@Override
	Object whatHolder() {
		return k.whatHolder();
	}

}
