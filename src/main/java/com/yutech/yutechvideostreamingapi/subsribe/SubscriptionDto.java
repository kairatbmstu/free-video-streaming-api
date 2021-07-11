package com.yutech.yutechvideostreamingapi.subsribe;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SubscriptionDto {

    @NotBlank(message = "userId is mandatory")
    String userId;

    @NotBlank(message = "channelId is mandatory")
    String channelId;

}
