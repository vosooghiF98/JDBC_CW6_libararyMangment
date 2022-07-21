package org.cw6_2;

import org.cw6_2.entity.Novel;
import org.cw6_2.entity.Writer;
import org.cw6_2.repository.NovelRepository;
import org.cw6_2.repository.WriterRepository;

import java.sql.SQLException;

public class Main {
    static WriterRepository writerRepository = new WriterRepository();
    static NovelRepository novelRepository = new NovelRepository();
    public static void main(String[] args) throws SQLException {
        Writer writer = new Writer();
        writer.setFirstName("farshid");
        writer.setLastName("vosooghi");
        writerRepository.addWriter(writer);
        Novel novel = new Novel();
        novel.setName("x");
        novel.setQuantity(2);
        novel.setWriterId(1);
        novelRepository.addNovel(novel);

    }
}
