package sample.aop.domain.store;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public interface IJustHaveALook extends IStore {

    double getPrice(String name);

    boolean isAvailable(String name);

}
