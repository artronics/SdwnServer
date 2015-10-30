package artronics.sdwn.server.resources.asm;

import artronics.sdwn.server.controller.SdwnNetworkController;
import artronics.sdwn.server.controller.SdwnNetworkSettingController;
import artronics.sdwn.server.model.SdwnNetwork;
import artronics.sdwn.server.resources.SdwnNetworkResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class SdwnNetworkResourceAsm extends ResourceAssemblerSupport<SdwnNetwork,
        SdwnNetworkResource>
{
    public SdwnNetworkResourceAsm()
    {
        super(SdwnNetworkController.class, SdwnNetworkResource.class);
    }

    @Override
    public SdwnNetworkResource toResource(SdwnNetwork sdwnNetwork)
    {
        SdwnNetworkResource resource = new SdwnNetworkResource();
        resource.setDescription(sdwnNetwork.getDescription());
        Link link = linkTo(SdwnNetworkController.class).slash(sdwnNetwork.getId()).withSelfRel();
        Link setting = linkTo(SdwnNetworkSettingController.class).slash(sdwnNetwork.getId())
                                                                 .withRel("setting");
        resource.add(link);
        resource.add(setting);

        return resource;
    }
}


