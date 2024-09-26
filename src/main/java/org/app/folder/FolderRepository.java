package org.app.folder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.app.model.Folder;
import org.app.util.JPAUtil;

import java.util.List;

public class FolderRepository extends JPAUtil {

//    public static List<?> findAll() {
//        EntityManager entityManager = getEntityManager();
//        for (EntityType<?> entity : entityManager.getMetamodel().getEntities()) {
//            System.out.println("Entity: " + entity.getName());
//        }
//        entityManager.getTransaction().begin();
//        List<?> folders = entityManager.createQuery("SELECT f FROM Folder f", Folder.class).getResultList();
//        commitAndCloseTransaction(entityManager);
//        return folders;
//    }
}
