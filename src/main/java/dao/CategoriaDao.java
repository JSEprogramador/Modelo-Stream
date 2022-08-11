package dao;

import model.Categoria;
import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    //PERSISTER TODOS OS REGISTRO FEITAS NO BANCO DE DADOS;
    private EntityManager em;


    public CategoriaDao(EntityManager em) {
        this.em = em;

    }

    public void cadastrar(Categoria categoria) {

        this.em.persist(categoria);

    }

    public List<Categoria> consultaTodos(){
        String jpql = "SELECT c FROM Categoria c";
        return em.createQuery(jpql, Categoria.class).getResultList();

    }

    public Categoria buscarPorId(int id_categoria) {
        return em.find(Categoria.class, id_categoria);//Busca somente o ID

    }

    public void removerGenero(Categoria categoria) {
        //Carrega no gerenciamento do JPA
        em.merge(categoria);
        //Remove genero
        this.em.remove(categoria);

    }

    public void alterarGenero(Categoria categoria) {
        em.merge(categoria);

    }
}