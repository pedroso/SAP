package br.com.felipepedroso.secondapp.menu;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import br.com.felipepedroso.secondapp.FragmentConteudo;
import br.com.felipepedroso.secondapp.FragmentConteudoMesa;
import br.com.felipepedroso.secondapp.MainActivity;
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

    public Fragment newInstance(String tagFragment, int position, MainActivity main){
        setNome(tagFragment);
        switch (position) {
            case 0:
                //home
                return new FragmentConteudo().newInstance(tagFragment);
            case 1:
                //Mesas
                FragmentConteudoMesa frag = new FragmentConteudoMesa();
                return frag.newInstance(tagFragment);
            case 2:
                //Contas
                return new FragmentContasSelecaoMesa().newInstance(tagFragment);
            default:
                return new FragmentConteudo().newInstance("Nenhum item de menu encontrado!");
        }
    }



}
