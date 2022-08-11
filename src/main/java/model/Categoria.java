package model;


import javax.persistence.*;

@Entity
@Table (name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;
    private String descricao;

    public Categoria() {

    }

    public Categoria(String descricao){
        this.descricao = descricao;
    }

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
