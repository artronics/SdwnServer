package artronics.sdwn.server.repositories;

import artronics.sdwn.server.model.SdwnNetwork;
import artronics.sdwn.server.model.SdwnNetworkSetting;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class SdwnNetworkRepoTest
{
    @Autowired
    private SdwnNetworkRepo repo;

    @Autowired
    private SdwnNetworkSettingRepo settingRepo;

    private SdwnNetwork sdwnNetwork;
    private SdwnNetworkSetting setting;


    @Before
    @Transactional
    @Rollback(false)
    public void setUp() throws Exception
    {
        sdwnNetwork= new SdwnNetwork();
        sdwnNetwork.setDescription("foo");
        repo.createSdwnNetwork(sdwnNetwork);

//        setting = new SdwnNetworkSetting();
//        setting.setDescription("bar");
////        setting.setId(sdwnNetwork.getId());
//
//        settingRepo.createSdwnNetworkSetting(setting);

    }

    @Test
    @Transactional
    public void create_sdwnNetwork(){
        SdwnNetwork sdwnNetwork = repo.findSdwnNetwork(this.sdwnNetwork.getId());
        assertNotNull(sdwnNetwork);
        assertEquals(sdwnNetwork.getDescription(),"foo");
    }

    @Test
    @Transactional
    public void check_for_default_setting_creation(){
        SdwnNetwork sdwnNetwork = repo.findSdwnNetwork(this.sdwnNetwork.getId());
        SdwnNetworkSetting setting = sdwnNetwork.getSetting();

        assertNotNull(setting);
        assertEquals(sdwnNetwork.getId(),setting.getId());
    }
}