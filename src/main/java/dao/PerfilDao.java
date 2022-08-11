package dao;

import model.Perfil;

import javax.persistence.EntityManager;
import java.util.List;

public class PerfilDao {


    //PERSISTER TODOS OS REGISTRO FEITAS NO BANCO DE DADOS;
    private EntityManager em;


    public PerfilDao(EntityManager em) {
        this.em = em;

    }

    public void cadastrar(Perfil perfil) {

        this.em.persist(perfil);

    }

    public List<Perfil> consultaTodos() {
        String jpql = "SELECT g FROM Perfil g";
        return em.createQuery(jpql, Perfil.class).getResultList();

    }

    public Perfil buscarPorId(int id_perfil) {
        return em.find(Perfil.class, id_perfil);//Busca somente o ID

    }

    public void removerPerfil(Perfil perfil) {
        //Carrega no gerenciamento do JPA
        em.merge(perfil);
        //Remove genero
        this.em.remove(perfil);

    }

    public void alterarPerfil(Perfil perfil) {
        em.merge(perfil);

    }
   }
