package artronics.sdwn.server.resources;

import artronics.sdwn.server.model.SdwnNetwork;
import org.springframework.hateoas.ResourceSupport;

public class SdwnNetworkResource extends ResourceSupport
{
    private String description;

    public SdwnNetwork toSdwnNetwork(){
        SdwnNetwork sdwnNetwork = new SdwnNetwork();
        sdwnNetwork.setDescription(description);

        return sdwnNetwork;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
