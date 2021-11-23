package com.example.demo;

public class Comment {
    String text, user;
    public Comment(String text, String user)
    {
        this.text = text;
        this.user = user;
    }
    String getText()
    {
        return text;
    }
    String getUser()
    {
        return user;
    }
    void setText(String text)
    {
        this.text = text;
    }
    void setName(String user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return user + ":" + text;
    }
}
