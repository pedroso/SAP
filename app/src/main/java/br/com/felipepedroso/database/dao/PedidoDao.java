package br.com.felipepedroso.database.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import br.com.felipepedroso.entity.Pedido.Pedido;

/**
 * Created by Felipe on 09/06/2015.
 */
public class PedidoDao extends BaseDaoImpl<Pedido, Long> {

    public PedidoDao(ConnectionSource connectionSource) throws SQLException {
        super(Pedido.class);
        setConnectionSource(connectionSource);
        initialize();
    }
}
