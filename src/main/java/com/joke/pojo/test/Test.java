package com.joke.pojo.test;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Test {
    private Integer id;
    private String Text;
    private String TextB;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("Text")
    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    @JsonProperty("TextB")
    public String getTextB() {
        return TextB;
    }

    public void setTextB(String textB) {
        TextB = textB;
    }
}
