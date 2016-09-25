package little.java;

public class Holder extends Kebab{
	Object o;
	
	Holder(Object _o){
		this.o = _o;
	}

	@Override
	boolean isVeggie() {
		return true;
	}

	@Override
	Object whatHolder() {
		// TODO Auto-generated method stub
		return o;
	}
}
