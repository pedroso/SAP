package br.com.felipepedroso.entity.Pessoa;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Felipe on 01/06/2015.
 */
@DatabaseTable(tableName = "funcionario")
public class Funcionario {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String Nome;

    @DatabaseField
    private String Cpf;

    @DatabaseField
    private String Funcao;


    public Funcionario(String nome, String cpf, String funcao) {
        setNome(nome);
        setCpf(cpf);
        setFuncao(funcao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String funcao) {
        Funcao = funcao;
    }
}
