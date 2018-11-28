package com.shurda.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.net.URLEncoder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ContractController.class)
public class ContractControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private ContractController controller;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((ViewResolver) (viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    public void checkForStatusOk() throws Exception {
        this.mockMvc.perform(get("/hello/contracts?nameFilter=" + URLEncoder.encode("%5EA.*%24", "UTF-8")))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void checkForBadRequest() throws Exception {
        this.mockMvc.perform(get("/hello/contracts"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}