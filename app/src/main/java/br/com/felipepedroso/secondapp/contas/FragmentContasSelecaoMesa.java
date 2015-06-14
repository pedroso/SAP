package br.com.felipepedroso.secondapp.contas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import br.com.felipepedroso.secondapp.R;
import br.com.felipepedroso.secondapp.menu.IInflated;

/**
 * Created by Felipe on 22/02/2015.
 */
public class FragmentContasSelecaoMesa extends Fragment implements IInflated {

    private boolean mSearchCheck;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";
    private String mesaSelecionada;

    public FragmentContasSelecaoMesa newInstance(String text){
        FragmentContasSelecaoMesa mFragment = new FragmentContasSelecaoMesa();
        Bundle mBundle = new Bundle();

        mBundle.putString(TEXT_FRAGMENT, text);

        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Aqui está a mágica do clique do menu, aqui definimos o conteudo dos fragments.
        View rootView = inflater.inflate(R.layout.fragment_contas_mesa, container, false);

        rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT ));

        Button btnSelecionarContaMesa = (Button) rootView.findViewById(R.id.btnVizualizarContaMesa);
        EditText numMesa = (EditText) rootView.findViewById(R.id.edtNumeroMesa);

        /*mesaSelecionada = numMesa.getText().toString();

        if(!"".equals(mesaSelecionada)){
            numMesa.setText(mesaSelecionada);
        }*/

        btnSelecionarContaMesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();

                Fragment mFragment = new FragmentContas().newInstance("ContaMesa");

                if (mFragment != null){
                    FragmentTransaction transaction = mFragmentManager.beginTransaction();

                    transaction.addToBackStack(null);
                    transaction.replace(R.id.container, mFragment, "FechamentoConta");
                    transaction.commit();
                }
            }
        });


        getActivity().setTitle("Contas");
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);

        //Select search item
        final MenuItem menuItem = menu.findItem(R.id.menu_search);
        menuItem.setVisible(true);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint(this.getString(R.string.search));

        ((EditText) searchView.findViewById(R.id.search_src_text))
                .setHintTextColor(getResources().getColor(R.color.nliveo_white));
        searchView.setOnQueryTextListener(onQuerySearchView);

        menu.findItem(R.id.menu_add).setVisible(true);

        mSearchCheck = false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        switch (item.getItemId()) {

            case R.id.menu_add:
                Toast.makeText(getActivity(), R.string.add, Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_search:
                mSearchCheck = true;
                Toast.makeText(getActivity(), R.string.search, Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private SearchView.OnQueryTextListener onQuerySearchView = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            if (mSearchCheck){
                // implement your search here
            }
            return false;
        }
    };

}
