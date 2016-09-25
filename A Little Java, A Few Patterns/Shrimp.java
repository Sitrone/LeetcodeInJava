package little.java;

public class Shrimp extends Kebab {
	Kebab k;
	
	Shrimp(Kebab _k){
		this.k = _k;
	}

	@Override
	boolean isVeggie() {
		return false;
	}

	@Override
	Object whatHolder() {
		return k.whatHolder();
	}
}
