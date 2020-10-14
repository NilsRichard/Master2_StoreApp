package sample.aop.domain.provider;

import java.util.HashMap;

import org.springframework.stereotype.Component;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Component
public class Provider implements IProvider {

    HashMap<String, Integer> stockPrice = new HashMap<>();

    HashMap<String, Long> orders = new HashMap<>();

    public Provider() {
        stockPrice.put("computer", 1200);
        stockPrice.put("chair", 15);
        stockPrice.put("table", 45);
    }

    @Override
    public float getPrice(String articleName) {
        return this.stockPrice.get(articleName);
    }

    @Override
    public void order(String articleName) {
        orders.put(articleName, System.currentTimeMillis());
    }

}
