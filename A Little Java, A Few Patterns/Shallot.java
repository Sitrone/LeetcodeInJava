package little.java;

public class Shallot extends Kebab {
	Kebab k;
	
	Shallot(Kebab _k){
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
