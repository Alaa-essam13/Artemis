package com.example.ecommerce.artemis;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artemis")
@AllArgsConstructor
public class ArtemisController {
    private final MessageProducer messageProducer;
    @GetMapping("/queue")
    public ResponseEntity<String> sendToQueue(@RequestParam String message) {
        messageProducer.sendToQueue(message);
        return ResponseEntity.ok().body("message sent to queue");
    }

    @GetMapping("/topic")
    public ResponseEntity<String> sendToTopic(@RequestParam String message) {
        messageProducer.sendToTopic(message);
        return ResponseEntity.ok().body("message sent to Topic");
    }

}
