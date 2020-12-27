package com.vk.resend_to_save;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageModel {

    @JsonProperty("from_id") private long user_id;
    @JsonProperty("attachments") private List<Attachment> attachments;

}
