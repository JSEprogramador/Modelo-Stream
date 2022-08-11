package dao;

import model.Categoria;
import model.Classificacao;

import javax.persistence.EntityManager;
import java.util.List;

public class ClassificacaoDao {

    //PERSISTER TODOS OS REGISTRO FEITAS NO BANCO DE DADOS;
    private EntityManager em;


    public ClassificacaoDao(EntityManager em) {
        this.em = em;

    }

    public void cadastrar(Classificacao classificacao) {

        this.em.persist(classificacao);

    }

    public List<Classificacao> consultaTodos() {
        String jpql = "SELECT c FROM Classificacao c";
        return em.createQuery(jpql, Classificacao.class).getResultList();

    }

    public Classificacao buscarPorId(int id_classificacao) {
        return em.find(Classificacao.class, id_classificacao);//Busca somente o ID

    }

    public void removerclassificacao(Classificacao classificacao) {
        //Carrega no gerenciamento do JPA
        em.merge(classificacao);
        //Remove genero
        this.em.remove(classificacao);

    }

    public void alterarclassificacao(Classificacao classificacao) {
        em.merge(classificacao);

    }
}
