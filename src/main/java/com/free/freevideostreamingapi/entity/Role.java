package com.free.freevideostreamingapi.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@Table
public class Role {

    @Id
    @PrimaryKey
    String id;

    @Column
    String code;

    @Column
    String name;

}
