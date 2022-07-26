package org.cw6_2.repository;

import org.cw6_2.config.DBConfig;
import org.cw6_2.entity.Writer;

import java.sql.*;

public class WriterRepository {
    public void save(Writer writer) throws SQLException {
        String query = """
        insert into writer (first_name,last_name)
        values (?,?);
        """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,writer.getFirstName());
        preparedStatement.setString(2,writer.getLastName());
        preparedStatement.executeUpdate();
        ResultSet generatedIds = preparedStatement.getGeneratedKeys();
        generatedIds.next();
        int id = generatedIds.getInt(1);
        writer.setId(id);
        preparedStatement.close();
    }

    public Writer loadById(int id) throws SQLException {
        String query = """
                select * from writer where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        if (resultSet.next()){
            Writer writer = new Writer();
            writer.setId(resultSet.getInt("id"));
            writer.setFirstName(resultSet.getString("first_name"));
            writer.setLastName(resultSet.getString("last_name"));
            resultSet.close();
            return writer;
        }else {
            resultSet.close();
            return null;
        }
    }


}
