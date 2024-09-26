package org.app.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "flashcardapp";

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static Object find(Class objectClass, String id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Object objectFound = entityManager.find(objectClass, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return objectFound;
    }

    public static void persist(Object object) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
