package com.vk.resend_to_save;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {

    private String type;

    @JsonProperty("object")
    private MessageModel message;

    // We aren't concerned about anything else

}
