package dao;

import model.Genero;
import model.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDao {
    //PERSISTER TODOS OS REGISTRO FEITAS NO BANCO DE DADOS;
    private EntityManager em;


    public UsuarioDao(EntityManager em) {
        this.em = em;

    }

    public void cadastrar(Usuario cliente) {

        this.em.persist(cliente);

    }

    public List<Usuario> consultaTodos() {
        String jpql = "SELECT g FROM Usuario g";
        return em.createQuery(jpql, Usuario.class).getResultList();

    }

    public List<Usuario> BuscarporEmail(String email) {
        String jpql = "SELECT g FROM Usuario g  where g.email = " + email + "";
        System.out.println(jpql);
        return em.createQuery(jpql, Usuario.class).getResultList();
    }

    public Usuario buscarPorId(int id_usuario) {
        return em.find(Usuario.class, id_usuario);//Busca somente o ID

    }

    public void removerUsuario(Usuario cliente) {
        //Carrega no gerenciamento do JPA
        em.merge(cliente);
        //Remove genero
        this.em.remove(cliente);

    }

    public void alterarUsuario(Usuario cliente){
        em.merge(cliente);

    }
}

