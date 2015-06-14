package br.com.felipepedroso.ViewHolder.model;

/**
 * Created by Felipe on 13/06/2015.
 */
public class ItemPedido {
    private String descricao;
    private String valor;
    private String quantidade;

    public ItemPedido() { }
    public ItemPedido(String descricao, String valor, String quantidade) {

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
