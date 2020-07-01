package com.sys.startmongodb;

import com.sys.startmongodb.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.jayway.jsonpath.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartMongodbApplicationTests {
    private static final Log log = LogFactory.getLog(StartMongodbApplicationTests.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void add() {
        User user = new User();
        user.set_id(3);
        user.setName("yangjingsong");
        user.setSex("男");
        mongoTemplate.insert(user);
        user.set_id(4);
        user.setName("songjingyang");
        user.setSex("男");
        mongoTemplate.insert(user);
        log.info("插入成功！");
    }

    @Test
    public void find() throws Exception {
        User user = new User();
        List<User> users = mongoTemplate.findAll(User.class);
        users.forEach(u -> {
            log.info(u.toString());
        });
    }

    @Test
    public void update() {
        mongoTemplate.updateFirst(query((CriteriaDefinition) where("name").is("凌康")), Update.update("name", "我是凌康"), User.class);
    }

    @Test
    public void delete() {
        User user = new User();
        user.set_id(2);
        mongoTemplate.remove(user);
    }


}
