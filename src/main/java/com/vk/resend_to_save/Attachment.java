package com.vk.resend_to_save;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {

    @JsonProperty("type") private String type; // must be "photo"
    @JsonProperty("photo") private Image image;

}
