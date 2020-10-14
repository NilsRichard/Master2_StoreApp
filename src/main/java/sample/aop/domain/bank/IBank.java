package sample.aop.domain.bank;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public interface IBank {

    /**
     * Makes a money transfer
     *
     * @return true if transfer was successful
     */
    boolean transfer(IAccount accountToDebit, IAccount accountToCredit, double amount);

}
