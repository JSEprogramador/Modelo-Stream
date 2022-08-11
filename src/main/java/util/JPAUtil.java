package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//classe para conectar com o banco de dados
public class JPAUtil {

    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("projeto_stream");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();

    }
}
