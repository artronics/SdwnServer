package artronics.sdwn.server.services;

import artronics.sdwn.server.model.SdwnNetwork;

public interface SdwnNetworkService
{
    SdwnNetwork find(Long id);
    SdwnNetwork create(SdwnNetwork sdwnNetwork);
    SdwnNetwork delete(Long id);
    SdwnNetwork update(Long id, SdwnNetwork sdwnNetwork);
}
