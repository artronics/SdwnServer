package artronics.sdwn.server.services;

import artronics.sdwn.server.model.SdwnNetworkSetting;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface SdwnNetworkSettingService
{
    SdwnNetworkSetting find(Long id);
}
