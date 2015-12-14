package org.mysy.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    @Autowired
    public ArticleService(final ArticleRepository repository) {
        this.repository = repository;
    }

    public Article save(final Article article) {
        return this.repository.save(article);
    }

    public Optional<Article> findArticle(final String id) {
        final Article article = this.repository.findOne(id);
        return Optional.ofNullable(article);
    }
}
