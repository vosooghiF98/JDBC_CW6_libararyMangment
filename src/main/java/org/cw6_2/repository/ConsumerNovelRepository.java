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

    public ResultSet loadById(int id) throws SQLException {
        String query = """
                select * from novel where id = ? and quantity>0;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

    public void update(int id) throws SQLException {
        String query2 = """
                    update novel set quantity = quantity - 1 where id = ?;                 
                    """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query2);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
