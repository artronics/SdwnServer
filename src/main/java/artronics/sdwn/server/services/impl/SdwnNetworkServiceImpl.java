package artronics.sdwn.server.services.impl;

import artronics.sdwn.server.model.SdwnNetwork;
import artronics.sdwn.server.repositories.SdwnNetworkRepo;
import artronics.sdwn.server.services.SdwnNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SdwnNetworkServiceImpl implements SdwnNetworkService
{
    @Autowired
    private SdwnNetworkRepo sdwnNetworkRepo;

    @Override
    public SdwnNetwork find(Long id)
    {
        return sdwnNetworkRepo.findSdwnNetwork(id);
    }

    @Override
    public SdwnNetwork create(SdwnNetwork sdwnNetwork)
    {
        return sdwnNetworkRepo.createSdwnNetwork(sdwnNetwork);
    }

    @Override
    public SdwnNetwork delete(Long id)
    {
        return null;
    }

    @Override
    public SdwnNetwork update(Long id, SdwnNetwork sdwnNetwork)
    {
        return null;
    }
}
