package kz.aitu.myservicee.controllers;

import kz.aitu.myservicee.entities.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
public class MyController {
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/index")
    public String printMessage() {
        return "Hello World!";
    }

    @GetMapping("/index/mycandidate")
    public String printCandidateInfo() {
        String jsonMessage = null;
        Candidate candidate1 = new Candidate(1, "Choi San", 26);
        try {
            jsonMessage = objectMapper.writeValueAsString(candidate1);
        } catch (JsonParseException e) {
            System.out.println("Parse Exception: " + e.getMessage());
        }

        return jsonMessage;
    }

    @PostMapping("/index/mynewcandidate")
    public String printNewCandidateInfo(@RequestBody Candidate candidate1) {
        String jsonMessage = null;

        try {
            jsonMessage = objectMapper.writeValueAsString(candidate1);
        } catch (Exception e) {
            System.out.println("Parse Exception: " + e.getMessage());
        }

        return jsonMessage;
    }
}