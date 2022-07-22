package org.cw6_2.service;

import org.cw6_2.config.DBConfig;
import org.cw6_2.entity.Novel;
import org.cw6_2.repository.ConsumerNovelRepository;
import org.cw6_2.repository.ConsumerRepository;
import org.cw6_2.repository.NovelRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsumerNovelService {
    private ConsumerRepository consumerRepository = new ConsumerRepository();
    private NovelRepository novelRepository = new NovelRepository();
    private ConsumerNovelRepository consumerNovelRepository = new ConsumerNovelRepository();

    public void buy(int consumerId, Novel novel) throws SQLException {
        String query = """
                select * from novel where id = ? and quantity>0;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, novel.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            consumerNovelRepository.save(consumerId, novel.getId());
            String query2 = """
                    update novel set quantity = quantity - 1 where id = ?;                 
                    """;
            preparedStatement = DBConfig.getConnection().prepareStatement(query2);
            preparedStatement.setInt(1,novel.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            novel.setQuantity(novel.getQuantity()-1);
        }
    }
}
