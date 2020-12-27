package com.vk.resend_to_save;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResendController {

    private MessageSender sender;

    public ResendController(MessageSender sender) {
        this.sender = sender;
    }

    @PostMapping("/")
    public ResponseEntity<String> respond(@RequestBody String requestString) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        RequestModel requestPOJO = mapper.readValue(requestString, RequestModel.class);

        if (requestPOJO.getType().equals("confirmation")) return new ResponseEntity<>("e66e4554", HttpStatus.OK);

        // Else extract the attachment and send back the copy;
        if (requestPOJO.getMessage().getUser_id() != -197092083) { // To prevent possible loop-sending
            if (requestPOJO.getMessage().getAttachments() != null) {
                for (Attachment a : requestPOJO.getMessage().getAttachments()) { // Resend every attached image separately
                    if (a.getType().equals("photo")) {
                        sender.send(a.getImage());
                    }
                }
            }
            else {
                System.out.println(requestString);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        sender.setMessagesRead(requestPOJO.getMessage().getUser_id());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
