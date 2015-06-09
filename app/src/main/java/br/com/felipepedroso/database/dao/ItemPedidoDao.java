package br.com.felipepedroso.database.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import br.com.felipepedroso.entity.Pedido.ItemPedido;

/**
 * Created by Felipe on 09/06/2015.
 */
public class ItemPedidoDao extends BaseDaoImpl<ItemPedido, Long> {

    public ItemPedidoDao(ConnectionSource connectionSource) throws SQLException {
        super(ItemPedido.class);
        setConnectionSource(connectionSource);
        initialize();
    }

}
