package artronics.satrapi.server.repositories;

import artronics.satrapi.server.model.SdwnNetworkSetting;

public interface SdwnNetworkSettingRepo
{
    SdwnNetworkSetting find(Long networkId);
    SdwnNetworkSetting createSdwnNetworkSetting(SdwnNetworkSetting setting);
}
