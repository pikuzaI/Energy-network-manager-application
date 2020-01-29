package com.luxoft.pikuza.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Data
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = 8571261118900116242L;

    @Id
    private String id;
}
