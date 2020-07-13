package com.vk.resend_to_save;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    private String id;
    private String owner_id;
    private String access_key;

    public String getIdentifier() {
        return "photo" + id + "_" + owner_id + "_" + access_key;
    }

}
