package br.com.felipepedroso.entity.Pedido;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import br.com.felipepedroso.entity.Enum.StatusMesa;

/**
 * Created by Felipe on 01/06/2015.
 */
@DatabaseTable(tableName = "conta")
public class Mesa {
    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private Integer numero;

    @DatabaseField
    private StatusMesa statusMesa;

    public Mesa(){ }

    public Mesa(Integer numero, StatusMesa statusMesa) {
        this.setNumero(numero);
        this.setStatusMesa(statusMesa);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public StatusMesa getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(StatusMesa statusMesa) {
        this.statusMesa = statusMesa;
    }
}
