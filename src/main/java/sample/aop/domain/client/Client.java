package sample.aop.domain.client;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.aop.domain.bank.IAccount;
import sample.aop.domain.store.IFastLane;
import sample.aop.domain.store.IJustHaveALook;
import sample.aop.domain.store.ILane;

@Component
public class Client implements IClient, IRun {

	@Autowired
	IFastLane fastLane;
	
	@Autowired
	ILane lane;
	
	@Autowired
	IJustHaveALook justHaveAlook;
	
	@Resource(name="clientAccount")
	IAccount clientAccount;
	

	@Override
	/**
	 * Starts a scenario
	 */
	public void run() {
		clientAccount.credit(10000);
		scenario1();
		scenario2();
	}
	
	private void scenario1() {
		fastLane.oneShotOrder(clientAccount, "chair");
	}
	
	
	private void scenario2() {
		lane.addItemToCart("computer");
		lane.addItemToCart("chair");
		lane.addItemToCart("table");
		lane.pay(clientAccount);
	}
	
	
}
