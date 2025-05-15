package com.example.rabbitmqdemo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.rabbitmqdemo.sender.MessageSender;

@RestController
@RequestMapping("/mensagens")
public class MessageController {

    private final MessageSender sender;

    public MessageController(MessageSender sender) {
        this.sender = sender;
    }

    @PostMapping
    public ResponseEntity<String> enviar(@RequestBody String mensagem) {
        sender.send(mensagem);
        return ResponseEntity.ok("Mensagem enviada!");
    }

    @GetMapping
    public ResponseEntity<String> teste() {
         return ResponseEntity.ok(" test!");
    }
}

