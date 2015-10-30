package artronics.sdwn.server.services;

import artronics.sdwn.server.model.SdwnNetworkSetting;

public interface SdwnNetworkSettingService
{
    SdwnNetworkSetting find(Long networkId);
    SdwnNetworkSetting create(Long networkId, SdwnNetworkSetting setting);

}
