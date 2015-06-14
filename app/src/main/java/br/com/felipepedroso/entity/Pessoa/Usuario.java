package br.com.felipepedroso.entity.Pessoa;

import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Felipe on 01/06/2015.
 */
@DatabaseTable(tableName = "usuario")
public class Usuario extends Funcionario{
    private String Usuario;
    private String Senha;

    public Usuario() { }
    public Usuario(String nome, String cpf, String funcao, String usuario, String senha) {
        super(nome, cpf, funcao);
        setUsuario(usuario);
        setSenha(senha);
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
