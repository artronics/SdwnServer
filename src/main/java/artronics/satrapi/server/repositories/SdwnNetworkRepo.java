package artronics.satrapi.server.repositories;

import artronics.satrapi.server.model.SdwnNetwork;

public interface SdwnNetworkRepo
{
    SdwnNetwork findSdwnNetwork(Long id);
    SdwnNetwork createSdwnNetwork(SdwnNetwork sdwnNetwork);
}
