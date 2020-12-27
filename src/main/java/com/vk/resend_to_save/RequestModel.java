package com.vk.resend_to_save;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.internal.jline.internal.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {

    @JsonProperty("type") private String type;
    @Nullable
    @JsonProperty("object.message") private MessageModel message;

    // We aren't concerned about anything else

}
