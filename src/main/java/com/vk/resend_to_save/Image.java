package com.vk.resend_to_save;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @JsonProperty("id") private String id;
    @JsonProperty("owner_id") private String owner_id;
    @JsonProperty("access_key") private String access_key;

    public String getIdentifier() {
        return "photo" + id + "_" + owner_id + "_" + access_key;
    }

}
