package br.com.felipepedroso.entity.Produto;

/**
 * Created by Felipe on 01/06/2015.
 */
public class Categoria {
    private Long Id;
    private String nome;
    private Categoria subCategoria;


    public Categoria(){ }
    public Categoria(String nome, Categoria subCategoria) {
        this.setNome(nome);
        this.setSubCategoria(subCategoria);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(Categoria subCategoria) {
        this.subCategoria = subCategoria;
    }
}
