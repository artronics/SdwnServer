package artronics.satrapi.server.controller;

import artronics.satrapi.server.model.SdwnNetworkSetting;
import artronics.satrapi.server.services.SdwnNetworkSettingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class SdwnNetworkSettingControllerTest
{
    @InjectMocks
    private SdwnNetworkSettingController controller;

    @Mock
    private SdwnNetworkSettingService service;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void get_setting_for_network() throws Exception
    {
        SdwnNetworkSetting setting = new SdwnNetworkSetting();
        setting.setDescription("foo");
        setting.setId(1L);

        when(service.find(1L)).thenReturn(setting);

        mockMvc.perform(get("/networks/setting/1"))
                .andExpect(status().isOk());

    }
}