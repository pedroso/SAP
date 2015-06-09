package br.com.felipepedroso.entity.Pessoa;

/**
 * Created by Felipe on 01/06/2015.
 */
public class Usuario extends Funcionario{
    private String Usuario;
    private String Senha;

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
