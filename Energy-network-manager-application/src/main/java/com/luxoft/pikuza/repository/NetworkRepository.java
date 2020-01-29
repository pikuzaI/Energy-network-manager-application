package com.luxoft.pikuza.repository;

import com.luxoft.pikuza.entities.Network;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface NetworkRepository extends MongoRepository<Network, String> {

    Network findOneById(@NotNull String networkId);

    Network findOneByChildren(@NotNull List<Network> networkList);
}
