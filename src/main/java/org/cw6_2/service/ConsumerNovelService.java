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
    private ConsumerNovelRepository consumerNovelRepository = new ConsumerNovelRepository();

    public void buy(int consumerId, Novel novel) throws SQLException {
        consumerNovelRepository.loadById(novel.getId());
        if (consumerNovelRepository.loadById(novel.getId()).next()) {
            consumerNovelRepository.save(consumerId, novel.getId());
            consumerNovelRepository.update(novel.getId());
            novel.setQuantity(novel.getQuantity()-1);
        }
    }
}
