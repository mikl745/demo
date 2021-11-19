package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.*;
import java.util.List;
import java.util.Arrays;

@Controller
@RestController
public class ApiController{
    private List<String> messages = new ArrayList<>();
    @GetMapping("messages")
    public List<String> getMessages() {
        return messages;
    }
    /* curl -X POST http://localhost:8080/messages -H 'Content-Type: text/plain' -d ...*/
    @PostMapping("messages")
    public void addMessage(@RequestBody String text) {
        messages.add(text);
    }

    /* curl -X GET http://localhost:8080/messages/index */
    @GetMapping("messages/{index}")
    public String getMessage(@PathVariable("index") Integer index) {
        return messages.get(index);
    }
    /* curl -X GET http://localhost:8080/messages/index */
    @DeleteMapping("messages/{index}")
    public void deleteText(@PathVariable("index") Integer index) {
        messages.remove((int) index);
    }

    /* curl -X PUT http://localhost:8080/messages -H 'Content-Type: text/plain' -d ...*/
    @PutMapping("messages/{index}")
    public void updateMessage(
            @PathVariable("index") Integer i,
            @RequestBody String message) {
        messages.remove((int) i);
        messages.add(i, message);
    }

    @GetMapping("messages/search/{text}")
    public Integer Search(@PathVariable("text") String s)
    {
        for (int i = 0; i < messages.size(); i++)
        {
            if (messages.get(i).contains(s))
                return i;
        }
        return -1;
    }

    @GetMapping("messages/count")
    public Integer Count()
    {
        return messages.size();
    }

    @DeleteMapping("messages/search/{text}")
    public void Del(@PathVariable("text") String s)
    {
        List<String> messages_ = new ArrayList<>();
        for (int i = messages.size() - 1; i >= 0; i--)
            if (!messages.get(i).contains(s))
                messages_.add(messages.get(i));
        messages = messages_;
    }
}