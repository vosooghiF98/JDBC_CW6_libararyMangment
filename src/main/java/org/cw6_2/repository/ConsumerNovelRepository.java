package org.cw6_2.repository;

import org.cw6_2.config.DBConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsumerNovelRepository {

    public void save(int consumerId, int novelId) throws SQLException {
        String query = """
                    insert into buys (novel_id, consumer_id) 
                    values (?,?)
                    """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,novelId);
        preparedStatement.setInt(2,consumerId);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
