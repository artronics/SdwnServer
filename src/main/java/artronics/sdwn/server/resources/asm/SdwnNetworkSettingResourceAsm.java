package artronics.sdwn.server.resources.asm;

import artronics.sdwn.server.controller.SdwnNetworkSettingController;
import artronics.sdwn.server.model.SdwnNetworkSetting;
import artronics.sdwn.server.resources.SdwnNetworkResource;
import artronics.sdwn.server.resources.SdwnNetworkSettingResource;
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
