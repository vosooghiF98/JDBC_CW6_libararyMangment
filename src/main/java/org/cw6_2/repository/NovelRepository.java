package org.cw6_2.repository;

import org.cw6_2.config.DBConfig;
import org.cw6_2.entity.Novel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NovelRepository {
    public void save(Novel novel) throws SQLException {
        String query = """
                insert into novel (name, quantity, writer_id) 
                values (?,?,?);
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setString(1,novel.getName());
        preparedStatement.setInt(2,novel.getQuantity());
        preparedStatement.setInt(3,novel.getWriter().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Novel loadById(int id) throws SQLException {
        String query = """
                select * from novel where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        if (resultSet.next()){
            Novel novel = new Novel();
            novel.setId(resultSet.getInt("id"));
            novel.setName(resultSet.getString("name"));
            novel.setQuantity(resultSet.getInt("quantity"));
            resultSet.close();
            return novel;
        }else {
            resultSet.close();
            return null;
        }
    }
}
