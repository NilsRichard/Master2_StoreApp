package sample.aop.domain.bank;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public interface IAccount {

    boolean debit(double amount);

    boolean credit(double amount);
}
