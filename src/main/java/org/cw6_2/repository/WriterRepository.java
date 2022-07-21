package org.cw6_2.repository;

import org.cw6_2.entity.Writer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


}
