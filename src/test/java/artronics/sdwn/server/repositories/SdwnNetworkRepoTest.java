package artronics.sdwn.server.repositories;

import artronics.sdwn.server.model.SdwnNetwork;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class SdwnNetworkRepoTest
{
    @Autowired
    private SdwnNetworkRepo repo;

    private SdwnNetwork sdwnNetwork;

    @Before
    @Transactional
    @Rollback(false)
    public void setUp() throws Exception
    {
        sdwnNetwork= new SdwnNetwork();
        sdwnNetwork.setDescription("foo");
        repo.createSdwnNetwork(sdwnNetwork);
    }

    @Test
    @Transactional
    public void create_sdwnNetwork(){
        SdwnNetwork sdwnNetwork = repo.findSdwnNetwork(this.sdwnNetwork.getId());
        assertNotNull(sdwnNetwork);
        assertEquals(sdwnNetwork.getDescription(),"foo");
    }

    @Test
    public void find_existing_model(){

    }
}