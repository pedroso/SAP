package br.com.felipepedroso.secondapp.menu;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import br.com.felipepedroso.secondapp.FragmentConteudo;
import br.com.felipepedroso.secondapp.FragmentConteudoMesa;
import br.com.felipepedroso.secondapp.contas.FragmentContasSelecaoMesa;

/**
 * Created by Felipe on 05/06/2015.
 */
public class MenuInflaterManager {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MenuInflaterManager() {

    }

    public Fragment newInstance(String tagFragment, int position){
        setNome(tagFragment);
        switch (position) {
            case 0:
                //home
                return new FragmentConteudo().newInstance(tagFragment);
            case 1:
                //Mesas
                return new FragmentConteudoMesa().newInstance(tagFragment);
            case 2:
                //Contas
                return new FragmentContasSelecaoMesa().newInstance(tagFragment);
            case 3:
                //Sair
                return new FragmentConteudo().newInstance("Quer mesmo sair?? rsrs");
            default:
                return new FragmentConteudo().newInstance("Nenhum item de menu encontrado!");
        }
    }



}
