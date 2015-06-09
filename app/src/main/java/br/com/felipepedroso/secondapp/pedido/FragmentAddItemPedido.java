package br.com.felipepedroso.secondapp.pedido;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import br.com.felipepedroso.secondapp.R;
import br.com.felipepedroso.secondapp.menu.IInflated;

public class FragmentAddItemPedido extends Fragment implements IInflated {
    private boolean mSearchCheck;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";

    public FragmentAddItemPedido newInstance(String text) {
        FragmentAddItemPedido fragment = new FragmentAddItemPedido();
        Bundle args = new Bundle();
        args.putString(TEXT_FRAGMENT, text);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_item_pedido, container, false);


        String[] itens = {"> Refrigerante", "> Bebidas Alcoólicas", "Suco de Laranja", "Suco de Maracujá", "Suco de Abacaxi", "Suco de Limão", "Suco de Morango"};

        ListView list = (ListView) rootView.findViewById(R.id.lstProduto);
        list.setAdapter(new ArrayAdapter<String>(rootView.getContext(), R.layout.item_pedido, itens));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adpterView, View view, int position, long arg3) {
                FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();

                Fragment mFragment = new FragmentDadosPedido().newInstance("Pedido");

                if (mFragment != null){
                    mFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.container, mFragment).commit();
                }

                //Toast.makeText(view.getContext(), "POSICAO: " + arg3, Toast.LENGTH_LONG).show();

            }
        });

        getActivity().setTitle("Pedido");
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
