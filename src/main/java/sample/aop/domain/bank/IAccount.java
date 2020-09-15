package sample.aop.domain.bank;

public interface IAccount {

	public boolean debit(double amount);

	public boolean credit(double amount);
}
