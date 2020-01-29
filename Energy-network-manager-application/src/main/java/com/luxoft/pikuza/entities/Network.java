package com.luxoft.pikuza.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.luxoft.pikuza.dao.NodeType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Document(collection = "node")
public class Network extends BaseEntity{
    private NodeType type;
    private String name;
    private String description;
    private Map<String, String> params;
    @JsonProperty("children")
    private List<Network> children;
}
