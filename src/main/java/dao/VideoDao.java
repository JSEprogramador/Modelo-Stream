package dao;

import model.Classificacao;
import model.Video;

import javax.persistence.EntityManager;
import java.util.List;

public class VideoDao {

    //PERSISTER TODOS OS REGISTRO FEITAS NO BANCO DE DADOS;
    private EntityManager em;


    public VideoDao(EntityManager em) {
        this.em = em;

    }

    public void cadastrar(Video video) {

        this.em.persist(video);

    }

    public List<Video> consultaTodos() {
        String jpql = "SELECT c FROM Video c";
        return em.createQuery(jpql, Video.class).getResultList();

    }

    public Video buscarPorId(int id_video) {
        return em.find(Video.class, id_video);//Busca somente o ID

    }

    public void removerclassificacao(Classificacao classificacao) {
        //Carrega no gerenciamento do JPA
        em.merge(classificacao);
        //Remove genero
        this.em.remove(classificacao);

    }

    public void alterarVideo(Video video) {
        em.merge(video);

    }
}
