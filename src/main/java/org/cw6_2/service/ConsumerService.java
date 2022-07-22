package org.cw6_2.service;

import org.cw6_2.entity.Consumer;
import org.cw6_2.repository.ConsumerRepository;

import java.sql.SQLException;

public class ConsumerService {
    private ConsumerRepository consumerRepository = new ConsumerRepository();

    public void save(Consumer consumer) throws SQLException {
        consumerRepository.save(consumer);
    }

    public void loadById (int id) throws SQLException {
        consumerRepository.loadById(id);
    }
}
