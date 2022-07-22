package org.cw6_2.repository;

import org.cw6_2.config.DBConfig;
import org.cw6_2.entity.Consumer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsumerRepository {
    public void save(Consumer consumer) throws SQLException {
        String query = """
        insert into consumer (first_name,last_name)
        values (?,?);
        """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setString(1,consumer.getFirstName());
        preparedStatement.setString(2,consumer.getLastName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Consumer loadById(int id) throws SQLException {
        String query = """
                select * from consumer where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        if (resultSet.next()){
            Consumer consumer = new Consumer();
            consumer.setId(resultSet.getInt("id"));
            consumer.setFirstName(resultSet.getString("first_name"));
            consumer.setLastName(resultSet.getString("last_name"));
            resultSet.close();
            return consumer;
        }else {
            resultSet.close();
            return null;
        }
    }
}
