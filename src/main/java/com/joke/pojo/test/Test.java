package com.joke.pojo.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


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

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", Text='" + Text + '\'' +
                ", TextB='" + TextB + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Test test = (Test) o;

        return new EqualsBuilder()
                .append(id, test.id)
                .append(Text, test.Text)
                .append(TextB, test.TextB)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(Text)
                .append(TextB)
                .toHashCode();
    }
}
