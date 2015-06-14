package br.com.felipepedroso.entity.Pedido;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import br.com.felipepedroso.entity.Produto.Produto;

/**
 * Created by Felipe on 01/06/2015.
 */
@DatabaseTable(tableName = "item_pedido")
public class ItemPedido {
    @DatabaseField(generatedId = true)
    private Long Id;

    @DatabaseField
    private Integer quantidade;

    private Pedido pedido;
    private Produto produto;

    public ItemPedido() { }
    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
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

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }
}
