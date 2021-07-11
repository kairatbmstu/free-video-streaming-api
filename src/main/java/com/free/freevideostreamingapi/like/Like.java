package com.free.freevideostreamingapi.like;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@Table("like")
public class Like {

    @Id
    @Column
    String id;

    @Column
    String userId;

    @Column
    String videoId;

    @Column
    String commentId;

}
