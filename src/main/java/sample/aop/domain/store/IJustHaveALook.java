package sample.aop.domain.store;

public interface IJustHaveALook extends IStore {

	public double getPrice(String name);
	
	public boolean isAvailable(String name);
	
}
