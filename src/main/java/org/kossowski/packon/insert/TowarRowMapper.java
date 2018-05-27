package org.kossowski.packon.insert;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TowarRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Towar t = new Towar();

        t.setTw_Id( resultSet.getLong( "tw_Id" ));
        t.setTw_Symbol( resultSet.getString( "tw_Symbol" ));
        t.setTw_Nazwa( resultSet.getString( "tw_Nazwa" ));

        return t;
    }
}
