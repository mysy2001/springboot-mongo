package org.mysy;


import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@ComponentScan(basePackages = "org.mysy.*")
public class FongoConfig  {

    protected String getDatabaseName() {
        return "mysy";
    }

    @Bean
    public Mongo mongo() {
        // uses fongo for in-memory tests
        return new Fongo(getDatabaseName()).getMongo();
    }

    public @Bean MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongo(), getDatabaseName());
        return mongoTemplate;
    }


}
