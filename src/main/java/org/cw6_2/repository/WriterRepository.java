package org.cw6_2.repository;

import org.cw6_2.entity.Writer;

import java.sql.*;

public class WriterRepository {
    private final Connection connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/","postgres","a*1294278F");
    public WriterRepository() throws SQLException {
    }

    public void addWriter(Writer writer) throws SQLException {
        String query = """
        insert into writer (first_name,last_name)
        values (?,?);
        """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,writer.getFirstName());
        preparedStatement.setString(2,writer.getLastName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Writer selectById (int id) throws SQLException {
        String query = """
                select * from writer where id = ?;
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
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
