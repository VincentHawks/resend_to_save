package com.vk.resend_to_save;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResendController {

    private MessageSender sender;

    @PostMapping("/")
    public ResponseEntity<String> respond(@RequestBody RequestModel request) {

        if(request.getType().equals("confirmation")) return new ResponseEntity<>("cfbbe0b5", HttpStatus.OK);

        // Else extract the attachment and send back the copy;
        for(Attachment a : request.getMessage().getAttachments()) {
            if(a.getType().equals("photo")) {
                sender.send(a.getImage());
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
