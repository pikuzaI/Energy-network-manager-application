package com.luxoft.pikuza.services;

import com.luxoft.pikuza.entities.Network;
import com.luxoft.pikuza.exceptions.CustomExceptions;

import java.util.List;

public interface NetworkService {
    List<Network> getAllNetworks();

    Network getNetworkById(String networkId) throws CustomExceptions;

    void saveNetwork(Network network) throws CustomExceptions;

    Network findByChildNode(List<Network> networkList) throws CustomExceptions;
}
