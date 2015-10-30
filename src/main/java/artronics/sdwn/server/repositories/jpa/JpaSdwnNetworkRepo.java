package artronics.sdwn.server.repositories.jpa;

import artronics.sdwn.server.model.SdwnNetwork;
import artronics.sdwn.server.model.SdwnNetworkSetting;
import artronics.sdwn.server.repositories.SdwnNetworkRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaSdwnNetworkRepo implements SdwnNetworkRepo
{
    @PersistenceContext
    EntityManager em;

    @Override
    public SdwnNetwork findSdwnNetwork(Long id)
    {
        return em.find(SdwnNetwork.class,id);
    }

    @Override
    public SdwnNetwork createSdwnNetwork(SdwnNetwork sdwnNetwork)
    {
        SdwnNetworkSetting setting = new SdwnNetworkSetting();
        setting.setDescription("default");
        sdwnNetwork.setSetting(setting);
        setting.setSdwnNetwork(sdwnNetwork);
        em.persist(sdwnNetwork);

        return sdwnNetwork;
    }
}
