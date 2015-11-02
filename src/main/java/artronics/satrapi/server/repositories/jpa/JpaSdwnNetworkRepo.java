package artronics.satrapi.server.repositories.jpa;

import artronics.satrapi.server.model.SdwnNetwork;
import artronics.satrapi.server.model.SdwnNetworkSetting;
import artronics.satrapi.server.repositories.SdwnNetworkRepo;
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
