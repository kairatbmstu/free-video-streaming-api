package com.free.freevideostreamingapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class LibraryDto {

    UUID id;
    String userId;
    List<String> playlistIds;

}
