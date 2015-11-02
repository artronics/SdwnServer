package artronics.satrapi.server.controller;

import artronics.satrapi.server.services.SdwnNetworkService;
import artronics.satrapi.server.model.SdwnNetwork;
import artronics.satrapi.server.resources.SdwnNetworkResource;
import artronics.satrapi.server.resources.asm.SdwnNetworkResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/networks")
public class SdwnNetworkController
{
    private SdwnNetworkService service;

    @Autowired
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
    public
    @ResponseBody
    ResponseEntity<SdwnNetworkResource> postSdwnNetwork(@RequestBody SdwnNetwork network)
    {
        SdwnNetwork created = service.create(network);

        SdwnNetworkResource resource = new SdwnNetworkResourceAsm().toResource(created);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(resource.getLink("self").getHref()));

        return new ResponseEntity<SdwnNetworkResource>(resource, headers, HttpStatus.CREATED);
    }

}
