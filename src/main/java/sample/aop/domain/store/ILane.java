package sample.aop.domain.store;

import sample.aop.domain.bank.IAccount;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public interface ILane extends IStore {

    void addItemToCart(String item);

    boolean pay(IAccount account);

}
