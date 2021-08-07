package com.free.freevideostreamingapi.domain.model;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Library {
    
    UUID id;
    String userId;
    List<String> playlistIds;
}
