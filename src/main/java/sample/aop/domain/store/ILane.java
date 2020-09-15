package sample.aop.domain.store;

import sample.aop.domain.bank.IAccount;

public interface ILane extends IStore {

	public void addItemToCart(String item);
	
	public boolean pay(IAccount account);
	
}
