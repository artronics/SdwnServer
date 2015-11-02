package artronics.satrapi.server.services;

import artronics.satrapi.server.model.SdwnNetworkSetting;

public interface SdwnNetworkSettingService
{
    SdwnNetworkSetting find(Long networkId);
    SdwnNetworkSetting create(Long networkId, SdwnNetworkSetting setting);

}
