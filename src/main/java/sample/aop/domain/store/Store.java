package sample.aop.domain.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.aop.domain.bank.IAccount;
import sample.aop.domain.bank.IBank;
import sample.aop.domain.provider.IProvider;

@Component
public class Store implements IStore, IFastLane, ILane, IJustHaveALook {

	@Autowired
	IBank bank;

	@Autowired
	IProvider provider;

	@Resource(name="storeAccount")
	IAccount storeAccount;

	HashMap<String, Integer> stockQuantity = new HashMap<String, Integer>();

	List<String> cart = new ArrayList<String>();

	public Store() {
		stockQuantity.put("computer", 1);
		stockQuantity.put("chair", 15);
		stockQuantity.put("table", 5);
	}

	private void updateStock(String articleName) {
		int nb = this.stockQuantity.get(articleName);
		this.stockQuantity.put(articleName, nb - 1);
	}

	@Override
	public double getPrice(String articleName) {
		return provider.getPrice(articleName) * 1.16;
	}

	@Override
	public boolean isAvailable(String articleName) {
		return this.stockQuantity.get(articleName) > 0;
	}

	@Override
	public void addItemToCart(String articleName) {
		this.cart.add(articleName);
	}

	@Override
	public boolean pay(IAccount clientAccount) {
		double total = 0;
		for (String item : cart) {
			total += getPrice(item);
		}

		boolean success = bank.transfert(clientAccount, this.storeAccount, total);

		if (!success)
			return false;
		else {
			for (String item : cart) {
				updateStock(item);
				if (!isAvailable(item))
					provider.order(item);
			}
		}

		if (success)
			cart.clear();

		return success;
	}

	@Override
	public boolean oneShotOrder(IAccount clientAccount, String articleName) {
		if (!isAvailable(articleName))
			return false;

		boolean success = bank.transfert(clientAccount, this.storeAccount, getPrice(articleName));

		if (success) {
			updateStock(articleName);
			if (!isAvailable(articleName))
				provider.order(articleName);
		}

		return success;
	}

}
