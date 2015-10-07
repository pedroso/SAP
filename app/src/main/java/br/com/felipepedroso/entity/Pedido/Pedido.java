package br.com.felipepedroso.entity.Pedido;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

import br.com.felipepedroso.entity.Pessoa.Funcionario;
import br.com.felipepedroso.entity.Pessoa.Usuario;

/**
 * Created by Felipe on 01/06/2015.
 */
@DatabaseTable(tableName = "pedido")
public class Pedido {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private Usuario usuario;

    @DatabaseField
    private Boolean enviado;

    @DatabaseField(foreign = true)
    private Conta conta;

    @ForeignCollectionField
    private Collection<ItemPedido> itensPedido;

    public Pedido() { }
    public Pedido(Usuario usuario, Conta conta) {
        setUsuario(usuario);
        setConta(conta);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Boolean getEnviado() {
        return enviado;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }

    public void addItemPedido(ItemPedido itemPedido){
        this.itensPedido.add(itemPedido);
    }
}
