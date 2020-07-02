package com.sys.startmongodb;

import com.sys.startmongodb.domain.User;
import com.sys.startmongodb.domain.UserMenu;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartMongodbApplicationTests {
    private static final Log log = LogFactory.getLog(StartMongodbApplicationTests.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void add() {
        User user = new User();
        user.setId(1);
        user.setName("yangjingsong");
        user.setSex("男");

        mongoTemplate.insert(user);
    }

    @Test
    public void addUserMenu() {
        UserMenu user = new UserMenu();
        user.setId(1);
        user.setName("yangjingsong");
        user.setSex("男");

        mongoTemplate.insert(user);
    }

    @Test
    public void delete() {
        User user = new User();
        user.setId(1);

        mongoTemplate.remove(user);
    }

    @Test
    public void update() {
        Update update = new Update();
        update.set("name", "22222");

        Query query = new Query(Criteria.where("id").is(2));
        mongoTemplate.upsert(query, update, User.class);
    }

    @Test
    public void find() {
        Query query = new Query(Criteria.where("id").is(1677787));
        List<User> userList = mongoTemplate.find(query, User.class);

        userList.forEach(u -> {
            log.info(u.toString());
        });
    }

}
