package little.java;

public class Radish extends Kebab {
	Kebab k;
	
	Radish(Kebab _k){
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
