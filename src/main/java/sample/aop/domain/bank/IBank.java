package sample.aop.domain.bank;

public interface IBank {
	
	/**
	 * Makes a money transfet
	 * @param debitedAccount
	 * @param creditedAccount
	 * @param amount
	 * @return true if transfert was successful 
	 */
	public boolean transfert(IAccount accountToDebit, IAccount accountToCredit, double amount);

}
