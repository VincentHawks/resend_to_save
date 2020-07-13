package com.vk.resend_to_save;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ResendController {

    @PostMapping("/")
    public ResponseEntity<String> respond(@RequestBody RequestModel request) {

        if(request.getType().equals("confirmation")) return new ResponseEntity<>("cfbbe0b5", HttpStatus.OK);

        // Else extract the attachment and send back the copy;

        System.out.println(request.getMessage().getAttachments().get(0).getImage());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
