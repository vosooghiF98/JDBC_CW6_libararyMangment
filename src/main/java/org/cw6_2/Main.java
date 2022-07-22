package org.cw6_2;

import org.cw6_2.entity.Novel;
import org.cw6_2.entity.Writer;
import org.cw6_2.repository.NovelRepository;
import org.cw6_2.repository.WriterRepository;
import org.cw6_2.service.ConsumerNovelService;
import org.cw6_2.service.WriterService;

import java.sql.SQLException;

public class Main {
    static WriterService writerService = new WriterService();

    public static void main(String[] args) throws SQLException {
        /*Writer writer = new Writer();
        writer.setFirstName("farshid");
        writer.setLastName("vosooghi");

        writer.addNovel(novel);
        novel.setWriter(writer);
        writerService.save(writer);
         */
        Novel novel = new Novel();
        novel.setName("x");
        novel.setQuantity(2);
        novel.setId(3);
        ConsumerNovelService consumerNovelService = new ConsumerNovelService();
        consumerNovelService.buy(1,novel);
    }
}
