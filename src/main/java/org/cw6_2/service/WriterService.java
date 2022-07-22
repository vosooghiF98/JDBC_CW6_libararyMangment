package org.cw6_2.service;

import org.cw6_2.entity.Novel;
import org.cw6_2.entity.Writer;
import org.cw6_2.repository.NovelRepository;
import org.cw6_2.repository.WriterRepository;

import java.sql.SQLException;

public class WriterService {
    private WriterRepository writerRepository = new WriterRepository();
    private NovelRepository novelRepository = new NovelRepository();
    public void save(Writer writer) throws SQLException {
        writerRepository.save(writer);
        for (int i = 0; i < writer.getNovels().size(); i++) {
            novelRepository.save(writer.getNovels().get(i));
        }
    }
    public void loadById (int id) throws SQLException {
        writerRepository.loadById(id);
    }

}
