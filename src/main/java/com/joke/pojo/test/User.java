package com.joke.pojo.test;


import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

  private Integer id;
  private String name;
  private Integer age;


  @JsonProperty("Id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @JsonProperty("Name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("Age")
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            '}';
  }
}
