package br.com.felipepedroso.entity.Produto;

/**
 * Created by Felipe on 01/06/2015.
 */
public class Produto {
    private Long id;
    private Categoria categoria;
    private String nome;
    private Double valor;

    public Produto() { }
    public Produto(Categoria categoria, String nome, Double valor) {
        this.setCategoria(categoria);
        this.setNome(nome);
        this.setValor(valor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
