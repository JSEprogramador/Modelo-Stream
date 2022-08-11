package model;


import javax.persistence.*;

@Entity
@Table(name = "classificacao")
public class Classificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_classificacao;
    private String descricao;


    public Classificacao() {
    }

    public Classificacao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_classificacao() {
        return id_classificacao;
    }

    public void setId_classificacao(int id_classificacao) {
        this.id_classificacao = id_classificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}