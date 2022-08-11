package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;

@Entity
@Table (name = "video")
public class Video {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment do Id no banco de dados

    private int id_video;
    private int id_temporada;
    private int id_episodio;
    private String nome;
    private String duracao;
    private Date datalancamento;
    private Date dataexpiracao;
    private int id_classificacao;
    private int id_categoria;
    private int id_genero;


    public Video() {
    }

    public Video(int id_video, int id_temporada, int id_episodio, String nome, String duracao, Date datalancamento, Date dataexpiracao, int id_classificacao, int id_categoria, int id_genero) {
        this.id_video = id_video;
        this.id_temporada = id_temporada;
        this.id_episodio = id_episodio;
        this.nome = nome;
        this.duracao = duracao;
        this.datalancamento = datalancamento;
        this.dataexpiracao = dataexpiracao;
        this.id_classificacao = id_classificacao;
        this.id_categoria = id_categoria;
        this.id_genero = id_genero;
    }

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    public int getId_temporada() {
        return id_temporada;
    }

    public void setId_temporada(int id_temporada) {
        this.id_temporada = id_temporada;
    }

    public int getId_episodio() {
        return id_episodio;
    }

    public void setId_episodio(int id_episodio) {
        this.id_episodio = id_episodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    public Date getDataexpiracao() {
        return dataexpiracao;
    }

    public void setDataexpiracao(Date dataexpiracao) {
        this.dataexpiracao = dataexpiracao;
    }

    public int getId_classificacao() {
        return id_classificacao;
    }

    public void setId_classificacao(int id_classificacao) {
        this.id_classificacao = id_classificacao;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }
}