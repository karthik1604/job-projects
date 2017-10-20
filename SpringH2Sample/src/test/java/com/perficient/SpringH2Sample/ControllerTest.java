package com.perficient.SpringH2Sample;

import com.perficient.SpringH2Sample.controller.SubscriberController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ControllerTest {

    private MockMvc mockMvc;

    @Test
    public void testfor400status() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new SubscriberController()).build();
        this.mockMvc.perform(post("/subscriber/get400")).andExpect(status().isBadRequest());


    }

    @Test
    public void testfor500status() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new SubscriberController()).build();
        this.mockMvc.perform(post("/subscriber/getE")).andExpect(status().isInternalServerError());


    }

//    public void testforSleep() throws Exception {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new SubscriberController()).build();
//        this.mockMvc.perform(post("/subscriber/getSleep")).andExpect();
//
//
//    }
}