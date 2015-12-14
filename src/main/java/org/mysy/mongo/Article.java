package org.mysy.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@Data
@Document(collection = "articles")
@TypeAlias(value = "article")
public class Article {

    @Id
    private String id;

    @Field(value = "title")
    private String title;

    public static Article of(final String id, final String title) {
        return new Article(id, title);
    }
}
