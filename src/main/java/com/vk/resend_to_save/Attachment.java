package com.vk.resend_to_save;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {

    private String type; // must be "image"

    @JsonProperty("photo")
    private Image image;

}
