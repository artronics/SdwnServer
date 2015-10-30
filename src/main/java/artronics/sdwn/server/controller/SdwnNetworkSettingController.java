package artronics.sdwn.server.controller;

import artronics.sdwn.server.model.SdwnNetworkSetting;
import artronics.sdwn.server.resources.SdwnNetworkResource;
import artronics.sdwn.server.resources.SdwnNetworkSettingResource;
import artronics.sdwn.server.resources.asm.SdwnNetworkResourceAsm;
import artronics.sdwn.server.resources.asm.SdwnNetworkSettingResourceAsm;
import artronics.sdwn.server.services.SdwnNetworkSettingService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/networks/setting")
public class SdwnNetworkSettingController
{
    private SdwnNetworkSettingService settingService;

    public SdwnNetworkSettingController(
            SdwnNetworkSettingService settingService)
    {
        this.settingService = settingService;
    }

    @RequestMapping(value = "/{networkId}",method = RequestMethod.GET)
    public ResponseEntity<SdwnNetworkSettingResource> getSetting(@PathVariable Long networkId){
        SdwnNetworkSetting networkSetting = settingService.find(networkId);

        if (networkSetting != null) {
            SdwnNetworkSettingResource resource =
                    new SdwnNetworkSettingResourceAsm().toResource(networkSetting);
            return new ResponseEntity<SdwnNetworkSettingResource>(resource,HttpStatus.OK);
        }

        return new ResponseEntity<SdwnNetworkSettingResource>(HttpStatus.OK);
    }
}
