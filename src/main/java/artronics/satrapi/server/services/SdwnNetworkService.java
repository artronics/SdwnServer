package artronics.satrapi.server.services;

import artronics.satrapi.server.model.SdwnNetwork;

public interface SdwnNetworkService
{
    SdwnNetwork find(Long id);
    SdwnNetwork create(SdwnNetwork sdwnNetwork);
    SdwnNetwork delete(Long id);
    SdwnNetwork update(Long id, SdwnNetwork sdwnNetwork);
}
