package br.com.felipepedroso.entity.Pedido;

import br.com.felipepedroso.entity.Produto.Produto;

/**
 * Created by Felipe on 01/06/2015.
 */
public class ItemPedido {
    private Long Id;
    private Pedido pedido;
    private Produto produto;

    public ItemPedido(Pedido pedido, Produto produto) {
        this.setPedido(pedido);
        this.setProduto(produto);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
