package sample.aop.domain.bank;

import org.springframework.stereotype.Component;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Component
public class Account implements IAccount {

    private String id;

    private double amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean debit(double amount) {
        double newAmount = this.amount - amount;
        if (newAmount > 0) {
            this.amount = newAmount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean credit(double amount) {
        this.amount += amount;
        return true;
    }

}
