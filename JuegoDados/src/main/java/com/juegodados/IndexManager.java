package com.juegodados;

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
    	if(mongoTemplate.collectionExists("users")) {
    		mongoTemplate.dropCollection("users");
//    		mongoTemplate.indexOps("users").dropIndex("username");
    	}
    	if(mongoTemplate.collectionExists("games")) {
    		mongoTemplate.dropCollection("games");
    	}
    	
       
        
    }
}
