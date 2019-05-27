package com.example.chapter1;

import com.example.chapter1.bean.User;
import com.example.chapter1.respository.UserJDBCRepository;
import com.example.chapter1.web.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter1ApplicationTests {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/get/hello?name=⼩小明")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    @Autowired
    UserJDBCRepository userJDBCRepository;

    @Autowired
    JdbcTemplate primaryJdbcTemplate;

    @Autowired
    JdbcTemplate secondJdbcTemplate;


    @Test public void testSave() {
        User user =new User("neo","test_0000000_frist_new",30);
        userJDBCRepository.saveUser(user,primaryJdbcTemplate);

        User user1 =new User("neo","test_9999_second",30);
        userJDBCRepository.saveUser(user1,secondJdbcTemplate);
    }


}
