package fdmc.repository;

import fdmc.domain.entities.Cat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Nino Bonev - 14.2.2019 г., 10:11
 */
public class CatRepositoryImpl implements CatRepository {

    private EntityManager entityManager;

    @Inject
    public CatRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Cat save(Cat entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Cat> findAll() {
        this.entityManager.getTransaction().begin();
        List<Cat> cats = this.entityManager
                .createQuery("SELECT c FROM Cat c", Cat.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return cats;
    }
}
