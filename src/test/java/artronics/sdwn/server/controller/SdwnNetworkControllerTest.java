package artronics.sdwn.server.controller;

import artronics.sdwn.server.model.SdwnNetwork;
import artronics.sdwn.server.services.SdwnNetworkService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class SdwnNetworkControllerTest
{

    @InjectMocks
    private SdwnNetworkController controller;

    @Mock
    private SdwnNetworkService service;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();

    }

    @Test
    public void test_get() throws Exception
    {
        mockMvc.perform(get("/networks")).andExpect(status().isOk()).andDo(print());

    }

    @Test
    public void get_existing_sdwnNetwork() throws Exception
    {
        SdwnNetwork network = new SdwnNetwork();
        network.setId(1L);
        network.setDescription("foo");

        when(service.find(1L)).thenReturn(network);

        mockMvc.perform(get("/networks/1"))
               .andExpect(jsonPath("$.description", is("foo")))
               .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/networks/1"))))
                .andExpect(status().isOk())
               .andDo(print());
    }
    @Test
    public void get_non_existing_network() throws Exception
    {
        when(service.find(1L)).thenReturn(null);

        mockMvc.perform(get("/networks/1"))
               .andExpect(status().isNotFound());
    }

}