package br.com.felipepedroso.entity.Pedido;

import android.net.wifi.WifiConfiguration;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import br.com.felipepedroso.entity.Enum.StatusConta;

/**
 * Created by Felipe on 01/06/2015.
 */
@DatabaseTable(tableName = "conta")
public class Conta {
    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private Mesa mesa;

    @DatabaseField
    private StatusConta statusConta;

    public Conta() { }
    public Conta(Mesa mesa, StatusConta statusConta) {
        this.setMesa(mesa);
        this.setStatusConta(statusConta);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        mesa = mesa;
    }

    public StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(StatusConta statusConta) {
        this.statusConta = statusConta;
    }
}
