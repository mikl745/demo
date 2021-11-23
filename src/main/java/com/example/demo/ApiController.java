package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.*;

@Controller
@RestController
public class ApiController {
    Map<String, ArrayList<Comment>> themes = new HashMap<String, ArrayList<Comment>>();


    @GetMapping("themes")
    public List<String> getTheme() {
        return new ArrayList<>(themes.keySet());
    }

    @PostMapping("themes")
    public void addTheme(@RequestBody String name) {
        themes.put(name, new ArrayList<Comment>());
    }

    @PutMapping("themes/{name}")
    public void updateUser(@PathVariable("name") String name, @RequestBody String new_name) {
        themes.put(new_name, new ArrayList<Comment>());
        themes.remove(name);
    }

    @DeleteMapping("themes/{name}")
    public void DelTheme(@PathVariable("name") String name)
    {
        themes.remove(name);
    }

    @GetMapping("themes/size")
    public Integer getThemeSize() {
        return themes.size();
    }

    @DeleteMapping("themes/all")
    public void DelAllTheme()
    {
        themes.clear();
    }

    @GetMapping("themes/{name}")
    public String getThemeToName(@PathVariable("name") String name) {
        StringBuilder ans = new StringBuilder();
        for (Comment comment : themes.get(name))
            ans.append(comment).append(" ");

        return ans.toString();
    }

    @PostMapping("themes/{name}/{user}")
    public void addComment(@PathVariable("name") String name, @PathVariable("user") String user, @RequestBody String text) {
        themes.get(name).add(new Comment(text, user));
    }

    @DeleteMapping("themes/{name}/{text}")
    public void DelCommentInTheme(@PathVariable("name") String name, @PathVariable("text") String text)
    {
        themes.get(name).removeIf(comment -> Objects.equals(comment.getText(), text));
    }

    @PutMapping("themes/{name}/{text}")
    public void updateComment(@PathVariable("name") String name, @PathVariable("text") String text, @RequestBody String new_text) {
        for (Comment comment : themes.get(name))
        {
            if (Objects.equals(comment.getText(), text))
            {
                comment.setText(new_text);
                break;
            }
        }
    }

    @GetMapping("themes/comments/{user}")
    public ArrayList<String> getCommentsToName(@PathVariable("user") String user) {
        ArrayList<String> ans = new ArrayList<String>();
        for (String name : themes.keySet())
        {
            for (Comment comment : themes.get(name))
            {
                if (Objects.equals(comment.getUser(), user))
                {
                    ans.add(comment.getText());
                }
            }
        }
        return ans;
    }

    @DeleteMapping("themes/comments/{user}")
    public void DelCommentsToName(@PathVariable("user") String user)
    {
        for (String name : themes.keySet())
            themes.get(name).removeIf(comment -> Objects.equals(comment.getUser(), user));
    }





    //@DeleteMapping("users/{index}")
    /*public void Del(@PathVariable("index") Integer i)
    {
        users.remove(users.get(i));
    }*/



    /* curl -X GET http://localhost:8080/messages/index
    @GetMapping("messages/{index}")
    public String getMessage(@PathVariable("index") Integer index) {
        return messages.get(index);
    }
    /* curl -X GET http://localhost:8080/messages/index
    @DeleteMapping("messages/{index}")
    public void deleteText(@PathVariable("index") Integer index) {
        messages.remove((int) index);
    }

    /* curl -X PUT http://localhost:8080/messages -H 'Content-Type: text/plain' -d ...
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

    */
}