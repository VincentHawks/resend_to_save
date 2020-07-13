package com.vk.resend_to_save;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageModel {

    private long user_id;
    private List<Attachment> attachments;

}
