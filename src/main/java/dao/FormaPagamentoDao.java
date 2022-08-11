package dao;

import model.Forma_Pagamento;

import javax.persistence.EntityManager;
import java.util.List;

public class FormaPagamentoDao {

    //PERSISTER TODOS OS REGISTRO FEITAS NO BANCO DE DADOS;
    private EntityManager em;


    public FormaPagamentoDao(EntityManager em) {
        this.em = em;

    }

    public void cadastrar(Forma_Pagamento pagamento) {

        this.em.persist(pagamento);

    }

    public List<Forma_Pagamento> consultaTodos() {
        String jpql = "SELECT c FROM Forma_Pagamento c";
        return em.createQuery(jpql, Forma_Pagamento.class).getResultList();

    }

    public Forma_Pagamento buscarPorId(int id_formapagamento) {
        return em.find(Forma_Pagamento.class, id_formapagamento);//Busca somente o ID

    }

    public void removerFormapagamento(Forma_Pagamento pagamento) {
        //Carrega no gerenciamento do JPA
        em.merge(pagamento);
        //Remove genero
        this.em.remove(pagamento);

    }

    public void alterarFormapagamento(Forma_Pagamento pagamento) {
        em.merge(pagamento);

    }
}

