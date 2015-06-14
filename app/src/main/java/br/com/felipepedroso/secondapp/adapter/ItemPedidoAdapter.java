package br.com.felipepedroso.secondapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.felipepedroso.ViewHolder.ItemPedidoViewHolder;
import br.com.felipepedroso.entity.Pedido.ItemPedido;
import br.com.felipepedroso.secondapp.R;

/**
 * Created by Felipe on 13/06/2015.
 */
public class ItemPedidoAdapter extends RecyclerView.Adapter<ItemPedidoViewHolder> {
    private List<ItemPedido> itemPedidoList;
    private Context mContext;

    public ItemPedidoAdapter(Context context, List<ItemPedido> itemPedidoList){
        this.mContext = context;
        this.itemPedidoList = itemPedidoList;
    }

    @Override
    public ItemPedidoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item_pedido, null);
        ItemPedidoViewHolder viewHolder = new ItemPedidoViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemPedidoViewHolder viewHolder, int i) {
        ItemPedido feedItem = itemPedidoList.get(i);

        viewHolder.setDescricao(feedItem.getProduto().getNome());
        viewHolder.setValor("R$ " + feedItem.getProduto().getValor().toString());
        viewHolder.setQuantidade(feedItem.getQuantidade().toString());
    }

    @Override
    public int getItemCount() {
        return itemPedidoList.size();
    }
}
