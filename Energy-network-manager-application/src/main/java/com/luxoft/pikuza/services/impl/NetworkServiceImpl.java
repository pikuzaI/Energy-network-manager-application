package com.luxoft.pikuza.services.impl;

import com.luxoft.pikuza.entities.Network;
import com.luxoft.pikuza.exceptions.CustomExceptions;
import com.luxoft.pikuza.repository.NetworkRepository;
import com.luxoft.pikuza.services.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkServiceImpl implements NetworkService {

    private final NetworkRepository networkRepository;

    @Autowired
    public NetworkServiceImpl(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public List<Network> getAllNetworks() {
        return networkRepository.findAll();
    }

    @Override
    public Network getNetworkById(String networkId) throws CustomExceptions {
        if (networkId == null)
            throw new CustomExceptions("NetworkID is null");
        return networkRepository.findOneById(networkId);
    }

    @Override
    public void saveNetwork(Network network) throws CustomExceptions {
        if (network == null)
            throw new CustomExceptions("Network is null");
        try {
            networkRepository.save(network);
        }
        catch (Exception ex)
        {
            throw new CustomExceptions("Incorrect data");
        }
    }

    @Override
    public Network findByChildNode(List<Network> networkList) throws CustomExceptions {
        try {
            return networkRepository.findOneByChildren(networkList);
        }
        catch (Exception ex){
            throw new CustomExceptions("Children is not exist");
        }
    }
}
