package com.free.freevideostreamingapi.channel;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class ChannelDto {

    String id;

    @NotBlank
    String title;

    String description;

    int subsribersNum;

    public ChannelDto(String id, String title, String description, int subsribersNum) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.subsribersNum = subsribersNum;
    }

    public ChannelDto() {
    }
}
