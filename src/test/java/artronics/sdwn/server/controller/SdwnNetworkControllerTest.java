package artronics.sdwn.server.controller;

import artronics.sdwn.server.model.SdwnNetwork;
import artronics.sdwn.server.services.SdwnNetworkService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    }

    @Test
    public void test_get() throws Exception
    {
        SdwnNetwork network = new SdwnNetwork();
        network.setId(1L);
        network.setDescription("foo");

        when(service.find(1L)).thenReturn(network);

        mockMvc.perform(get("/networks/1"))
               .andExpect(jsonPath("$.description", is("foo")))
               .andExpect(status().isOk());
    }

    //    @Test
    public void get_existing_sdwnNetwork() throws Exception
    {
    }

    @Test
    public void create_sdwn_network() throws Exception
    {
        SdwnNetwork network = new SdwnNetwork();
        network.setId(1L);
        network.setDescription("foo");

        when(service.create(any(SdwnNetwork.class))).thenReturn(network);

        mockMvc.perform(post("/networks")
                                .content("{\"description\":\"foo\"}")
                                .contentType(MediaType.APPLICATION_JSON))

               .andExpect(jsonPath("$.description", is(network.getDescription())))
               .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("networks/1"))))
               .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("networks/setting/1"))))
               .andExpect(header().string("Location", endsWith("networks/1")))
               .andExpect(status().isCreated());
    }

    @Test
    public void get_non_existing_network() throws Exception
    {
        when(service.find(1L)).thenReturn(null);

        mockMvc.perform(get("/networks/1"))
               .andExpect(status().isNotFound());
    }


}