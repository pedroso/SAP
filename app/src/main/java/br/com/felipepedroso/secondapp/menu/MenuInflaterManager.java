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

    public MenuInflaterManager() {

    }

    public Fragment newInstance(String text, int position){
        switch (position) {
            case 0:
                //home
                return new FragmentConteudo().newInstance(text);
            case 1:
                //Mesas
                return new FragmentConteudoMesa().newInstance(text);
            case 2:
                //Contas
                return new FragmentContasSelecaoMesa().newInstance(text);
            case 3:
                //Sair
                return new FragmentConteudo().newInstance("Quer mesmo sair?? rsrs");
            default:
                return new FragmentConteudo().newInstance("Nenhum item de menu encontrado!");
        }
    }



}
