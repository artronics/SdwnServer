package artronics.satrapi.server.resources.asm;

import artronics.satrapi.server.controller.SdwnNetworkSettingController;
import artronics.satrapi.server.resources.SdwnNetworkSettingResource;
import artronics.satrapi.server.model.SdwnNetworkSetting;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class SdwnNetworkSettingResourceAsm
        extends ResourceAssemblerSupport
                        <SdwnNetworkSetting, SdwnNetworkSettingResource>
{
    public SdwnNetworkSettingResourceAsm()
    {
        super(SdwnNetworkSettingController.class, SdwnNetworkSettingResource.class);
    }

    @Override
    public SdwnNetworkSettingResource toResource(SdwnNetworkSetting sdwnNetworkSetting)
    {
        SdwnNetworkSettingResource resource = new SdwnNetworkSettingResource();
        resource.setDescription(sdwnNetworkSetting.getDescription());

        return resource;
    }
}
