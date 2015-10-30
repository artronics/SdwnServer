package artronics.sdwn.server.services.impl;

import artronics.sdwn.server.model.SdwnNetworkSetting;
import artronics.sdwn.server.services.SdwnNetworkSettingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SdwnNetworkSettingServiceImpl implements SdwnNetworkSettingService
{
    @Override
    public SdwnNetworkSetting find(Long id)
    {
        return null;
    }
}
