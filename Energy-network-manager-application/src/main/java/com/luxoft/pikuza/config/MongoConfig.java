package com.luxoft.pikuza.config;

import com.mongodb.ReadPreference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.luxoft.pikuza.repository")
@EnableMongoAuditing
public class MongoConfig {
    @Autowired
    private MongoDbFactory mongoDbFct;

    public @Bean
    MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate( mongoDbFct );
        mongoTemplate.setReadPreference( ReadPreference.nearest() );
        return mongoTemplate;
    }

    public @Bean
    PersistenceExceptionTranslator mongoExpTranslator() {
        return mongoDbFct.getExceptionTranslator();
    }
}
