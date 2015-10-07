package br.com.felipepedroso.factory.pedido;

import br.com.felipepedroso.entity.Pedido.Conta;
import br.com.felipepedroso.entity.Pedido.ItemPedido;
import br.com.felipepedroso.entity.Pedido.Pedido;
import br.com.felipepedroso.entity.Pessoa.Usuario;
import br.com.felipepedroso.entity.Produto.Produto;

/**
 * Created by Felipe on 15/06/2015.
 */
public class ItemPedidoFactory {

    public ItemPedidoFactory() {

    }

    public ItemPedido createItemPedido(String descricao, Double valor, Integer quantidade){

        return new ItemPedido(new Pedido(new Usuario(), new Conta()), new Produto(null, descricao, valor ), quantidade );
    }

}
