package model;


import javax.persistence.*;

@Entity
@Table(name = "formapagamento_descricao")
public class Forma_Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_formapagamento;
    private String descricao;

    public Forma_Pagamento() {
    }

    public Forma_Pagamento(String descricao) {
        this.descricao = descricao;
    }

    public int getId_formapagamento() {
        return id_formapagamento;
    }

    public void setId_formapagamento(int id_formapagamento) {
        this.id_formapagamento = id_formapagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
