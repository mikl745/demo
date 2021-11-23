package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Theme {
    String name;
    List<Comment> comm = new ArrayList<>();
    public Theme()
    {
        this.name = "none";
    }
    public Theme(String name)
    {
        this.name = name;
    }
    void reName(String name)
    {
        this.name = name;
    }

}
