package com.free.freevideostreamingapi.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Like {
    String id;
    String userId;
    String videoId;
    String commentId;
}
