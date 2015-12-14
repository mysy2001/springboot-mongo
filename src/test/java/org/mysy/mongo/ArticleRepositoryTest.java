package org.mysy.mongo;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mysy.FongoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableMongoRepositories
@ContextConfiguration(classes = FongoConfig.class)
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository objectUnderTest;

    @Autowired
    private ApplicationContext applicationContext;

    @Rule
    public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("mysy");

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @UsingDataSet(locations = {"/json/articles.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void shouldFindOneArticle() throws Exception {

        final String id = "article";
        final Article expected = Article.of(id, "title");
        final Article result = objectUnderTest.findOne(id);

        assertThat(result).isEqualTo(expected);



    }
}