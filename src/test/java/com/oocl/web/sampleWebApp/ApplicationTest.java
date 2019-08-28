package com.oocl.web.sampleWebApp;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }
    
    @Test
    public void shouldReturnDefaultMessage1() throws Exception {
        this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Hello World")));
    }
    
    @Test
    public void shouldGotNameInBody() throws Exception {
        this.mockMvc.perform(
        		get("/user")
        )
        .andDo(print())
        .andExpect(
        		status().isOk()
        )
        .andExpect(
        		MockMvcResultMatchers.jsonPath(
        				"$.user",
        				CoreMatchers.is("name")
        		)
//        		content().string(containsString("Hello World")));
        );
    }
    
    
    @Autowired
    private ObjectMapper objectMapper ;
    
    @Test
    public void shouldGotGeneratedInBody() throws Exception {
    	HashMap map = new HashMap();
    	String postString = objectMapper.writeValueAsString(map) ;
        this.mockMvc.perform(
        		MockMvcRequestBuilders
        		.post("/users")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(postString)
        )
        .andDo(print())
        .andExpect(
        		status().()
        )
        .andExpect(
        		MockMvcResultMatchers.jsonPath(
        				"$.id",
        				CoreMatchers.is("001")
        		)
        );
    } 
    
    
}