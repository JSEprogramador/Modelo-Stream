package model;


import javax.persistence.*;

@Entity
@Table(name ="genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment do Id no banco de dados
    private int id_genero;
    private String descricao;

    public Genero(){


    }


    public Genero(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id_genero;
    }

    public void setId(long id) {
        this.id_genero = id_genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}