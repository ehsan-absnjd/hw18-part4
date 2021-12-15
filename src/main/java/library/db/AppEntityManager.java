package library.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppEntityManager {
    private static EntityManagerFactory factory= Persistence
            .createEntityManagerFactory("library");
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
    public static void close(){
        factory.close();
    }
}
