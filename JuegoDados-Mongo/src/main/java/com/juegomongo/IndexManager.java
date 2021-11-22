package com.juegomongo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
class IndexManager implements InitializingBean {

    private MongoTemplate mongoTemplate;

    public IndexManager(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void afterPropertiesSet() {
    	 mongoTemplate.indexOps("users").dropIndex("username");
        mongoTemplate.indexOps("players").dropIndex("name");
        mongoTemplate.dropCollection("players");
        mongoTemplate.dropCollection("users");
        mongoTemplate.dropCollection("games");
    }
}
