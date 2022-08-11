package model;


import javax.persistence.*;

@Entity
@Table (name = "tipousuario")
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_tipousuario;
    private String descricao;

    public TipoUsuario() {
    }

    public TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public int getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(int id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
