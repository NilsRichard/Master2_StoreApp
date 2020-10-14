package sample.aop.domain.provider;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public interface IProvider {

    float getPrice(String articleName);

    void order(String articleName);
}
