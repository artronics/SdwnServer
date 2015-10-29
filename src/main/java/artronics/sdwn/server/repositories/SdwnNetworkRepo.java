package artronics.sdwn.server.repositories;

import artronics.sdwn.server.model.SdwnNetwork;

public interface SdwnNetworkRepo
{
    SdwnNetwork findSdwnNetwork(Long id);
    SdwnNetwork createSdwnNetwork(SdwnNetwork sdwnNetwork);
}
