package br.com.felipepedroso.secondapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.com.felipepedroso.consumidor.RetrieveFeedTask;
import br.com.felipepedroso.database.helper.DataBaseHelper;


public class IndexActivity extends FragmentActivity {
    FragmentManager fragManager = getSupportFragmentManager();
    private DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //helper = new DataBaseHelper(this);
        //this.inserirProduto();

        if(savedInstanceState == null){
            FragmentConteudo fragmentConteudo = new FragmentConteudo();
            FragmentConteudoMesa fragmentConteudoMesa = new FragmentConteudoMesa();

            FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_conteudo, fragmentConteudo);
            fragmentTransaction.commit();
        }

        String[] lista = new String[]{"Home", "Alterar texto Fragment!", "Mesas", "Pedidos"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);

        ListView listView = (ListView) findViewById(R.id.menuListView);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                //FragmentConteudo fragConteudo = (FragmentConteudo) fragManager.findFragmentById(R.id.fragment1);
                if(position == 0){
                    int totalFrags = fragManager.getFragments().size();
                    String tag = totalFrags != 0 ? fragManager.getFragments().get(totalFrags -1).getTag() : "";

                    if(!"fragmentConteudo".equals(tag)) {
                        FragmentConteudo fragmentConteudo = new FragmentConteudo();
                        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_conteudo, fragmentConteudo, "fragmentConteudo");
                        fragmentTransaction.addToBackStack("pilha");
                        fragmentTransaction.commit();
                    }
                }else if(position == 1){
                    FragmentConteudo fragConteudo = (FragmentConteudo) fragManager.findFragmentByTag("fragmentConteudo");
                    String resposta = "Requisitando! ";
                    try {
                        RetrieveFeedTask feedTask = new RetrieveFeedTask();
                        feedTask.setFragmentConteudo(fragConteudo);
                        resposta = "Alterado pelo menu! RESPONSE: " + feedTask.execute();
                    }catch (Exception e) {
                        resposta = "Não foi possível acessar o web-service! Dick! =@";
                    }
                }else if(position == 2){
                    int totalFrags = fragManager.getFragments().size();
                    String tag = totalFrags != 0 ? fragManager.getFragments().get(totalFrags -1).getTag() : "";

                    if(!"fragmentConteudoMesa".equals(tag)) {
                        FragmentConteudoMesa fragmentConteudoMesa = new FragmentConteudoMesa();
                        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_conteudo, fragmentConteudoMesa, "fragmentConteudoMesa");
                        fragmentTransaction.addToBackStack("pilha");
                        fragmentTransaction.commit();
                    }
                }else if(position == 3){

                }
            }
        });
    }

    public void inserirProduto(){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("descricao", "Coca-Cola 600ml");

        long resultadoInsert = db.insert("produto", null, values);

        if(resultadoInsert != -1){
            Toast.makeText(this, "Produto inserido com sucesso!", Toast.LENGTH_LONG);
        }else{
            Toast.makeText(this, "Não foi possível inserir um produto!", Toast.LENGTH_LONG);
        }
    }
}
