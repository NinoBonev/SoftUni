package fdmc.config;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Nino Bonev - 14.2.2019 г., 10:15
 */
public class ApplicationBeanConfig {

    @Produces
    public EntityManager entityManager(){
        return Persistence
                .createEntityManagerFactory("fdmc")
                .createEntityManager();
    }

    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
