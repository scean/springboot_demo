package com.example.chapter1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageControllerTests {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        saveTestMessage();
    }

    @Test
    public void createMessage() throws Exception {
        MultiValueMap<String,String> message = new LinkedMultiValueMap<>();
        message.add("text","this is test3");
        message.add("summary","this is summary3");
        String respContent = mockMvc.perform(MockMvcRequestBuilders.post("/message/create").params(message)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("Result = "+respContent);
    }

    @Test
    public void getMessage() throws Exception{
        String respContent = mockMvc.perform(MockMvcRequestBuilders.get("/message/get/1")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("Result = "+respContent);
    }

    @Test
    public void getAllMessage() throws Exception{
        String respContent = mockMvc.perform(MockMvcRequestBuilders.get("/message/getAll")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("Result = "+respContent);
    }

    @Test
    public void saveAllMessage() throws Exception {
        MultiValueMap<String,String> message = new LinkedMultiValueMap<>();
        message.add("text","this is test3");
        message.add("summary","this is summary3");
        String a = "[{\"id\":1,\"text\":\"this is test 0\",\"summary\":\"this is summary 0\"},{\"id\":2,\"text\":\"this is test 1\",\"summary\":\"this is summary 1\"},{\"id\":3,\"text\":\"this is test 2\",\"summary\":\"this is summary 2\"},{\"id\":4,\"text\":\"this is test 3\",\"summary\":\"this is summary 3\"},{\"id\":5,\"text\":\"this is test 4\",\"summary\":\"this is summary 4\"},{\"id\":6,\"text\":\"this is test 5\",\"summary\":\"this is summary 5\"},{\"id\":7,\"text\":\"this is test 6\",\"summary\":\"this is summary 6\"},{\"id\":8,\"text\":\"this is test 7\",\"summary\":\"this is summary 7\"},{\"id\":9,\"text\":\"this is test 8\",\"summary\":\"this is summary 8\"},{\"id\":10,\"text\":\"this is test 9\",\"summary\":\"this is summary 9\"}]\n";
        String respContent = mockMvc.perform(MockMvcRequestBuilders.post("/message/saveAll").content(a).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("Result = "+respContent);
    }
    private void saveTestMessage() throws Exception {
        for(int i= 0;i<10;i++){
            MultiValueMap<String,String> message = new LinkedMultiValueMap<>();
            message.add("text","this is test "+ i);
            message.add("summary","this is summary "+i);
            String respContent = mockMvc.perform(MockMvcRequestBuilders.post("/message/create").params(message)
                    .accept(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
            System.out.println("save test data = "+respContent);
        }
    }
}
