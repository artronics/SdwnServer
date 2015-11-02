package artronics.satrapi.server.services.impl;

import artronics.satrapi.server.model.SdwnNetwork;
import artronics.satrapi.server.repositories.SdwnNetworkSettingRepo;
import artronics.satrapi.server.model.SdwnNetworkSetting;
import artronics.satrapi.server.repositories.SdwnNetworkRepo;
import artronics.satrapi.server.services.SdwnNetworkSettingService;
import artronics.satrapi.server.services.exceptions.ModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SdwnNetworkSettingServiceImpl implements SdwnNetworkSettingService
{
    @Autowired
    private SdwnNetworkSettingRepo settingRepo;

    @Autowired
    private SdwnNetworkRepo networkRepo;


    @Override
    public SdwnNetworkSetting find(Long id)
    {
        return settingRepo.find(id);
    }

    @Override
    public SdwnNetworkSetting create(Long networkId, SdwnNetworkSetting setting)
    {
        SdwnNetwork sdwnNetwork = networkRepo.findSdwnNetwork(networkId);
        if (sdwnNetwork == null) {
            throw new ModelNotFoundException();
        }

        SdwnNetworkSetting fetched = settingRepo.createSdwnNetworkSetting(setting);
        fetched.setSdwnNetwork(sdwnNetwork);

        return fetched;
    }
}
