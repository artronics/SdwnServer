package artronics.sdwn.server.repositories;

import artronics.sdwn.server.model.SdwnNetworkSetting;

public interface SdwnNetworkSettingRepo
{
    SdwnNetworkSetting find(Long networkId);
    SdwnNetworkSetting createSdwnNetworkSetting(SdwnNetworkSetting setting);
}
