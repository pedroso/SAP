package br.com.felipepedroso.secondapp.pedido;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.felipepedroso.entity.Pedido.Conta;
import br.com.felipepedroso.entity.Pedido.ItemPedido;
import br.com.felipepedroso.entity.Pedido.Pedido;
import br.com.felipepedroso.entity.Pessoa.Usuario;
import br.com.felipepedroso.entity.Produto.Produto;
import br.com.felipepedroso.factory.pedido.ItemPedidoFactory;
import br.com.felipepedroso.secondapp.R;
import br.com.felipepedroso.secondapp.adapter.ItemPedidoAdapter;
import br.com.felipepedroso.secondapp.menu.IInflated;

public class FragmentPedido extends Fragment implements IInflated {

    private boolean mSearchCheck;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";
    RecyclerView recyclerList;
    ItemPedidoAdapter adapter;

    public FragmentPedido newInstance(String text) {
        FragmentPedido fragment = new FragmentPedido();
        Bundle args = new Bundle();
        args.putString(TEXT_FRAGMENT, text);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pedido, container, false);

        Button btnInserirItem = (Button) rootView.findViewById(R.id.btnAddItem);
        Button btnFinalizar = (Button) rootView.findViewById(R.id.btnFinalizar);
        recyclerList = (RecyclerView) rootView.findViewById(R.id.lstItemPedido);
        recyclerList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
                mFragmentManager.popBackStack();
            }
        });

        btnInserirItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();

                Fragment mFragment = new FragmentAddItemPedido().newInstance("SelecaoPedido");

                if (mFragment != null){
                    FragmentTransaction transaction = mFragmentManager.beginTransaction();
                    transaction.addToBackStack(null).replace(R.id.container, mFragment, "SelecaoPedido").commit();
                }
            }
        });

        List<ItemPedido> itemPedidoList = new ArrayList<ItemPedido>();
        ItemPedidoFactory factory = new ItemPedidoFactory();

        //Bundle bundle = new Bundle();

        itemPedidoList.add(factory.createItemPedido("Suco de Laranja", new Double(4.5), 2 ));
        itemPedidoList.add(factory.createItemPedido("Suco de Maracujá", new Double(4.5), 1 ));
        itemPedidoList.add(factory.createItemPedido("X-Tudo", new Double(13.5), 1 ));
        itemPedidoList.add(factory.createItemPedido("X-Salada", new Double(10.5), 1 ));
        itemPedidoList.add(factory.createItemPedido("Coca-Cola 1L", new Double(4.5), 1 ));
        //itemPedidoList.add(factory.createItemPedido(bundle.getString("descricao"), bundle.getDouble("valor"), bundle.getInt("quantidade")));


        adapter = new ItemPedidoAdapter(rootView.getContext(), itemPedidoList);
        recyclerList.setAdapter(adapter);

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
