package artronics.sdwn.server.resources;

import artronics.sdwn.server.model.SdwnNetworkSetting;
import org.springframework.hateoas.ResourceSupport;

public class SdwnNetworkSettingResource extends ResourceSupport
{
    private String description;

    public SdwnNetworkSetting toSdwnNetworkSetting(){
        SdwnNetworkSetting networkSetting = new SdwnNetworkSetting();
        networkSetting.setDescription(description);

        return networkSetting;
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
