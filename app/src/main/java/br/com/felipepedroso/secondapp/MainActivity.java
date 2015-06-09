package br.com.felipepedroso.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import br.com.felipepedroso.secondapp.menu.MenuInflaterManager;
import br.liveo.Model.HelpLiveo;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.navigationliveo.NavigationLiveo;

public class MainActivity extends NavigationLiveo implements OnItemClickListener {

    private HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle savedInstanceState) {
        this.userName.setText("SAPBR");
        this.userEmail.setText("Sistema de Automação de Pedidos");
        this.userPhoto.setImageResource(R.drawable.ic_launcher);
        this.userBackground.setImageResource(R.drawable.ic_user_background_first);

        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.home), R.mipmap.ic_home);
        mHelpLiveo.add(getString(R.string.mesas, R.mipmap.ic_drawer), R.mipmap.ic_table);
        mHelpLiveo.add(getString(R.string.contas, R.mipmap.ic_drawer), R.mipmap.ic_money);
        mHelpLiveo.add(getString(R.string.sign_out, R.mipmap.ic_drawer), R.mipmap.ic_sign_out);

        with(this).startingPosition(0)
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem(R.string.app_name, R.drawable.logo_sistema)
                .setOnClickUser(onClickPhoto)
                .setOnClickFooter(onClickFooter)
                .build();

    }

    @Override
    public void onBackPressed() {
        FragmentManager mFragmentManager = getSupportFragmentManager();

        int totalFragments = mFragmentManager.getBackStackEntryCount();

        if(totalFragments <= 0) {

            menuClickAction(3);//3 == Sign out
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(int position) {
        menuClickAction(position);
    }

    private void menuClickAction(int position){
        FragmentManager mFragmentManager = getSupportFragmentManager();
        //Criar uma classe, que a partir da posicao retorna o mFragment.
        //EU pensei que no FragmentConteudo faria o inflate das views, mas não é assim.
        //quando instacio e chamo o method newInstance, estou falando que quei abrir aquele fragment
        //essa linha abaixo irá ficar na classe gerenciadora de conteudo.
        //Fragment mFragment = new FragmentConteudo().newInstance(mHelpLiveo.get(position).getName(), position);
        Fragment mFragment = new MenuInflaterManager().newInstance(mHelpLiveo.get(position).getName(), position);

        if (mFragment != null){
            mFragmentManager.beginTransaction()
                    //.addToBackStack(null)
                    .replace(R.id.container, mFragment)
                    .commit();
        }
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "onClickPhoto :D", Toast.LENGTH_SHORT).show();
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            closeDrawer();
        }
    };
}