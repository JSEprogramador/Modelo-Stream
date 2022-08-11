package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_usuario;
    private String nome;
    private String senha;
    private String cpf;
    private String email;
    private int id_tipousuario;
    private Date datarenovacao;
    private int id_formapagamento;

    public Usuario() {
    }

    public Usuario(String nome, String senha, String cpf, String email, int id_tipousuario, Date datarenovacao, int id_formapagamento) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.id_tipousuario = id_tipousuario;
        this.datarenovacao = datarenovacao;
        this.id_formapagamento = id_formapagamento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(int id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public Date getDatarenovacao() {
        return datarenovacao;
    }

    public void setDatarenovacao(Date datarenovacao) {
        this.datarenovacao = datarenovacao;
    }

    public int getId_formapagamento() {
        return id_formapagamento;
    }

    public void setId_formapagamento(int id_formapagamento) {
        this.id_formapagamento = id_formapagamento;
    }
}
