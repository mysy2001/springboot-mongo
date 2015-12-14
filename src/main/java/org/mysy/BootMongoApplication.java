package org.mysy;

import lombok.extern.slf4j.Slf4j;
import org.mysy.mongo.Article;
import org.mysy.mongo.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BootMongoApplication implements CommandLineRunner{

    @Autowired
    private ArticleService articleService;

    public static void main(String[] args) {
        SpringApplication.run(BootMongoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        Article article = Article.of("article2", "Second article title 3");

        log.info("saving {}", article);
        Article saved = articleService.save(article);
        log.info("saved {}", saved);

    }
}
