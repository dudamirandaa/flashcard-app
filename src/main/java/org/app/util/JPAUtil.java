package org.app.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.app.model.Folder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "flashcardapp";

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void commitAndCloseTransaction(EntityManager entityManager) {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static <T> T find(Class<T> objectClass, String id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        T objectFound = entityManager.find(objectClass, id);
        commitAndCloseTransaction(entityManager);
        return objectFound;
    }

    public static List<Folder> findAll() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        List<Folder> folders = entityManager.createQuery("SELECT f FROM Folder f", Folder.class).getResultList();
        commitAndCloseTransaction(entityManager);
        return folders;
    }

    public static void persist(Object object) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        commitAndCloseTransaction(entityManager);
    }

    public static <T> T delete(Class<T> objectClass, String id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        T objectFound = entityManager.find(objectClass, id);
        entityManager.remove(objectFound);
        commitAndCloseTransaction(entityManager);
        return objectFound;
    }
}
