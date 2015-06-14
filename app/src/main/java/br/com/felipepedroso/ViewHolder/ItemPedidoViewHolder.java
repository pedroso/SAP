package br.com.felipepedroso.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.felipepedroso.secondapp.R;

/**
 * Created by Felipe on 13/06/2015.
 */
public class ItemPedidoViewHolder extends RecyclerView.ViewHolder {
    protected TextView descricao;
    protected TextView valor;
    protected TextView quantidade;

    public ItemPedidoViewHolder(View view) {
        super(view);
        this.descricao = (TextView) view.findViewById(R.id.COLUMN_DESCRICAO);
        this.valor = (TextView) view.findViewById(R.id.COLUMN_VALOR);
        this.quantidade = (TextView) view.findViewById(R.id.COLUMN_QTDE);
    }

    public void setDescricao(String descricao) {
        this.descricao.setText(descricao);
    }

    public void setValor(String valor) {
        this.valor.setText(valor);
    }

    public void setQuantidade(String quantidade) {
        this.quantidade.setText(quantidade);
    }
}