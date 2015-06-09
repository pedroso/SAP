package br.com.felipepedroso.entity.Pedido;

import br.com.felipepedroso.entity.Pessoa.Funcionario;
import br.com.felipepedroso.entity.Pessoa.Usuario;

/**
 * Created by Felipe on 01/06/2015.
 */
public class Pedido {
    private Long id;
    private Usuario usuario;
    private Conta conta;

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
}
