package artronics.sdwn.server.controller;

import artronics.sdwn.server.model.SdwnNetwork;
import artronics.sdwn.server.resources.SdwnNetworkResource;
import artronics.sdwn.server.resources.asm.SdwnNetworkResourceAsm;
import artronics.sdwn.server.services.SdwnNetworkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jnetworks")
public class SdwnNetworkController
{
    private SdwnNetworkService service;

    public SdwnNetworkController(SdwnNetworkService service)
    {
        this.service = service;
    }

    @RequestMapping(value ="/{networkId}", method= RequestMethod.GET)
    public ResponseEntity<SdwnNetworkResource> getSdwnNetwork(@PathVariable Long networkId)
    {
        SdwnNetwork sdwnNetwork = service.find(networkId);
        if (sdwnNetwork != null) {
            SdwnNetworkResource resource = new SdwnNetworkResourceAsm().toResource(sdwnNetwork);
            return new ResponseEntity<SdwnNetworkResource>(resource, HttpStatus.OK);
        }

        return new ResponseEntity<SdwnNetworkResource>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody SdwnNetwork postSdwnNetwork(@RequestBody SdwnNetwork entry)
    {
        return entry;
    }

}
