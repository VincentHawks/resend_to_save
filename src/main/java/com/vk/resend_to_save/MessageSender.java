package com.vk.resend_to_save;

import lombok.NonNull;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class MessageSender {

    private final RestTemplate restTemplate;

    public MessageSender(@NonNull RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public void send(Image image) {
        Random random = new Random();
        StringBuilder url = new StringBuilder();
        url.append("https://api.vk.com/method/messages.send?user_id=").append(image.getOwner_id())
                .append("&random_id=").append(random.nextLong())
                .append("&peer_id=").append(image.getOwner_id())
                .append("&attachment=").append(image.getIdentifier())
                .append("&access_token=a253e1632a7cbaeef7f67387e19a9c08dda0e7b14a7c3eca4e4ec6d07bb3457d81b259d45be30ae50e070")
                .append("&v=5.50");
        String response = this.restTemplate.getForObject(url.toString(), String.class);
        System.out.println(response);
    }

}
