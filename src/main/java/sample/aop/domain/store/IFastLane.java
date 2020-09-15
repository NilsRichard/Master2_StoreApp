package sample.aop.domain.store;

import sample.aop.domain.bank.IAccount;

public interface IFastLane extends IStore {

	public boolean oneShotOrder(IAccount clientAccount, String articleName);
}
