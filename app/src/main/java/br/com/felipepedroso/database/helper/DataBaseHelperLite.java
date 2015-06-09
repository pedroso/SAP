package br.com.felipepedroso.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.felipepedroso.entity.Pedido.ItemPedido;
import br.com.felipepedroso.entity.Pedido.Pedido;

/**
 * Created by Felipe on 09/06/2015.
 */
public class DataBaseHelperLite extends OrmLiteSqliteOpenHelper{
    private static final String BANCO_DADOS = "SAPBR";
    private static final int VERSAO = 2;

    public DataBaseHelperLite(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource cs) {

        try {
            TableUtils.createTable(cs, Pedido.class);
            TableUtils.createTable(cs, ItemPedido.class);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource cs, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(cs, Pedido.class, true);
            TableUtils.dropTable(cs, ItemPedido.class, true);
            onCreate(database, cs);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
