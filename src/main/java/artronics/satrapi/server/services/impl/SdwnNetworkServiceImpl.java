package artronics.satrapi.server.services.impl;

import artronics.satrapi.server.repositories.SdwnNetworkSettingRepo;
import artronics.satrapi.server.services.SdwnNetworkService;
import artronics.satrapi.server.model.SdwnNetwork;
import artronics.satrapi.server.repositories.SdwnNetworkRepo;
import artronics.satrapi.server.services.exceptions.ModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SdwnNetworkServiceImpl implements SdwnNetworkService
{
    @Autowired
    private SdwnNetworkRepo sdwnNetworkRepo;

    @Autowired
    private SdwnNetworkSettingRepo settingRepo;

    @Override
    public SdwnNetwork find(Long id)
    {
        return sdwnNetworkRepo.findSdwnNetwork(id);
    }

    @Override
    public SdwnNetwork create(SdwnNetwork sdwnNetwork)
    {
//        SdwnNetworkSetting setting = new SdwnNetworkSetting();
//        setting.setDescription("default set");
//        sdwnNetwork.setSetting(setting);
        SdwnNetwork fetched = sdwnNetworkRepo.createSdwnNetwork(sdwnNetwork);
        if (fetched == null)
            throw new ModelNotFoundException();

        return fetched;
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
