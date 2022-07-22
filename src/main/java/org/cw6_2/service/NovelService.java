package org.cw6_2.service;

import org.cw6_2.entity.Novel;
import org.cw6_2.repository.NovelRepository;

import java.sql.SQLException;

public class NovelService {
    private NovelRepository novelRepository = new NovelRepository();

    public void save(Novel novel) throws SQLException {
        novelRepository.save(novel);
    }

    public void loadById(int id) throws SQLException {
        novelRepository.loadById(id);
    }
}
