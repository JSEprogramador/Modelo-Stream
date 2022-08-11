package dao;

import javax.persistence.EntityManager;
import java.util.List;

import model.Genero;

public class GeneroDao {

    //PERSISTER TODOS OS REGISTRO FEITAS NO BANCO DE DADOS;
    private EntityManager em;


    public GeneroDao(EntityManager em) {
        this.em = em;

    }

    public void cadastrar(Genero genero) {

        this.em.persist(genero);

    }

    public List<Genero> consultaTodos() {
        String jpql = "SELECT g FROM Genero g";
        return em.createQuery(jpql, Genero.class).getResultList();

    }

    public Genero buscarPorId(long id_genero) {
        return em.find(Genero.class, id_genero);//Busca somente o ID

    }

    public void removerGenero(Genero genero) {
        //Carrega no gerenciamento do JPA
        em.merge(genero);
        //Remove genero
        this.em.remove(genero);

    }

    public void alterarGenero(Genero genero) {
        em.merge(genero);

    }
}

