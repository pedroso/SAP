package br.com.felipepedroso.secondapp;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.GridView;
        import android.widget.Toast;

        import br.com.felipepedroso.secondapp.pedido.FragmentPedido;
        import br.com.felipepedroso.secondapp.adapter.ImageAdapter;
        import br.com.felipepedroso.secondapp.menu.IInflated;

/**
 * Created by Felipe on 22/02/2015.
 */
public class FragmentConteudoMesa extends Fragment implements IInflated {
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_conteudo_mesa, null);

        // Locate GridView in listview_main.xml
        GridView gridview = (GridView) view.findViewById(R.id.gridview);

        // Set the ImageAdapter into GridView Adapter
        gridview.setAdapter(new ImageAdapter(view.getContext()));

        // Capture GridView item click
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();

            Fragment mFragment = new FragmentPedido().newInstance("Pedido");

            if (mFragment != null){
                mFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.container, mFragment).commit();
            }

            }
        });

        getActivity().setTitle("Mesas");

        return (view);
    }

    @Override
    public Fragment newInstance(String text) {
        FragmentConteudoMesa mFragment = new FragmentConteudoMesa();
        Bundle mBundle = new Bundle();

        mBundle.putString(TEXT_FRAGMENT, text);

        mFragment.setArguments(mBundle);

        return mFragment;
    }
}
