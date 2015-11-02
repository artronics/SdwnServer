package artronics.satrapi.server.controller;

import artronics.satrapi.server.resources.SdwnNetworkSettingResource;
import artronics.satrapi.server.model.SdwnNetworkSetting;
import artronics.satrapi.server.resources.asm.SdwnNetworkSettingResourceAsm;
import artronics.satrapi.server.services.SdwnNetworkSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
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
