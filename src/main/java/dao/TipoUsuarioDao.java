package dao;

import model.Genero;
import model.TipoUsuario;

import javax.persistence.EntityManager;
import java.util.List;

public class TipoUsuarioDao {

    //PERSISTER TODOS OS REGISTRO FEITAS NO BANCO DE DADOS;
    private EntityManager em;


    public TipoUsuarioDao(EntityManager em) {
        this.em = em;

    }

    public void cadastrar(TipoUsuario usuario) {

        this.em.persist(usuario);

    }

    public List<TipoUsuario> consultaTodos() {
        String jpql = "SELECT g FROM TipoUsuario g";
        return em.createQuery(jpql, TipoUsuario.class).getResultList();

    }

    public TipoUsuario buscarPorId(int id_tipousuario) {
        return em.find(TipoUsuario.class, id_tipousuario);//Busca somente o ID

    }

    public void removerUsuario(TipoUsuario usuario) {
        //Carrega no gerenciamento do JPA
        em.merge(usuario);
        //Remove genero
        this.em.remove(usuario);

    }

    public void alterartipoUsuario(TipoUsuario usuario) {
        em.merge(usuario);

    }
}

