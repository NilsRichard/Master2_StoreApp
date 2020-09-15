package sample.aop.domain.provider;

public interface IProvider {

	public float getPrice(String articleName);

	public void order(String articleName);
}
