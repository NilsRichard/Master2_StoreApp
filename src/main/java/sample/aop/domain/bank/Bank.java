package sample.aop.domain.bank;

import org.springframework.stereotype.Component;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Component
public class Bank implements IBank {

    @Override
    public boolean transfer(IAccount accountToDebit, IAccount accountToCredit, double amount) {

        boolean debited = accountToDebit.debit(amount);

        boolean credited = accountToCredit.credit(amount);

        if (debited && credited)
            return true;
        else {
            if (debited)
                accountToDebit.credit(amount);
            if (credited)
                accountToCredit.debit(amount);
        }
        return false;

    }

}
