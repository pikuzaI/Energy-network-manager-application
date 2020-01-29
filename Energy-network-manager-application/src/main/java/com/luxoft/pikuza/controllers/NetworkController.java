package com.luxoft.pikuza.controllers;

import com.luxoft.pikuza.entities.Network;
import com.luxoft.pikuza.exceptions.CustomExceptions;
import com.luxoft.pikuza.services.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NetworkController {

    private final NetworkService networkService;

    @Autowired
    public NetworkController(NetworkService networkService) {
        this.networkService = networkService;
    }

    @GetMapping("/allNetworks")
    @ResponseBody
    public ResponseEntity<?> getAllNetworks()
    {
        return new ResponseEntity<>(networkService.getAllNetworks() , HttpStatus.OK);
    }

    @GetMapping("/getNetwork/{id}")
    @ResponseBody
    public ResponseEntity<?> getNetworkByID(@PathVariable("id") String id) throws CustomExceptions {
        return new ResponseEntity<>(networkService.getNetworkById(id) , HttpStatus.OK);
    }

    @PostMapping("/saveNetwork")
    public ResponseEntity<?> saveNetwork(@Valid @RequestBody Network network) throws CustomExceptions {
        networkService.saveNetwork(network);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateNetwork")
    public ResponseEntity<?> updateNetwork(@Valid @RequestBody Network network) throws CustomExceptions {
        networkService.saveNetwork(network);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findByChildNode")
    @ResponseBody
    public ResponseEntity<?> findByChildNode(@RequestParam("child") List<Network> list) throws CustomExceptions {
        return new ResponseEntity<>(networkService.findByChildNode(list),HttpStatus.OK);
    }
}
