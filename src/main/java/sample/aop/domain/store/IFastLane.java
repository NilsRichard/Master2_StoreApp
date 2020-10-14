package sample.aop.domain.store;

import sample.aop.domain.bank.IAccount;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public interface IFastLane extends IStore {

    boolean oneShotOrder(IAccount clientAccount, String articleName);
}
