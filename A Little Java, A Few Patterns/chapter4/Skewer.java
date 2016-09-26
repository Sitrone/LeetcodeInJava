package little.java.chapter4;

public class Skewer extends ShishD{

	@Override
	boolean onlyOnions() {
		return ooFn.forSkewer();
	}

	@Override
	boolean isVegetarian() {
		return ivFn.forSkewer();
	}
	
}
