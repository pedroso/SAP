package br.com.felipepedroso.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Felipe on 05/03/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String BANCO_DADOS = "SAPBR";
    private static final int VERSAO = 2;

    //PRODUTOS
    private static final String TBL_CATEGORIA = "CREATE TABLE categoria ( _id INTEGER PRIMARY KEY, descricao TEXT, idCategoria INTEGER, dataCriacao DATE);";

    private static final String TBL_PRODUTO = "CREATE TABLE produto ( _id INTEGER PRIMARY KEY, descricao TEXT);";

    private static final String TBL_ITEM_CATEGORIA = "CREATE TABLE itemCategoria ( _id INTEGER PRIMARY KEY," +
                                                                                " idProduto INTEGER," +
                                                                                " idCategoria INTEGER," +
                                                                                " FOREIGN KEY(idCategoria) REFERENCES categoria(_id)," +
                                                                                " FOREIGN KEY(idProduto) REFERENCES produto(_id));";
    //PEDIDOS
    private static final String TBL_MESA = "CREATE TABLE mesa ( _id INTEGER PRIMARY KEY, ocupada BOOL );";

    private static final String TBL_PEDIDO = "CREATE TABLE pedido ( _id INTEGER PRIMARY KEY, idMesa INTEGER,"+
                                                                                " FOREIGN KEY(idMesa) REFERENCES mesa(_id) );";

    private static final String TBL_ITEM_PEDIDO = "CREATE TABLE itemPedido ( _id INTEGER PRIMARY KEY, quantidade INTEGER," +
                                                                                " observacao TEXT," +
                                                                                " idPedido INTEGER," +
                                                                                " idProduto INTEGER," +
                                                                                " FOREIGN KEY(idPedido) REFERENCES pedido(_id)," +
                                                                                " FOREIGN KEY(idProduto) REFERENCES produto(_id));";



    public DataBaseHelper(Context context){
        super(context, BANCO_DADOS, null, VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.TBL_CATEGORIA);
        db.execSQL(this.TBL_PRODUTO);
        db.execSQL(this.TBL_ITEM_CATEGORIA);
        db.execSQL(this.TBL_MESA);
        db.execSQL(this.TBL_PEDIDO);
        db.execSQL(this.TBL_ITEM_PEDIDO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
