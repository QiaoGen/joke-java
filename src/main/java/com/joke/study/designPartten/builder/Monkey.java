package com.joke.study.designPartten.builder;

public class Monkey {

    private String category;
    private int age;
    private String name;

    public static class Builder{
        private final String categotry;

        private int age = 0;
        private String name = "";

        public Builder(String categotry){
            this.categotry = categotry;
        }

        public Builder age(int val){
            age = val;
            return this;
        }

        public Builder name(String val){
            name = val;
            return this;
        }

        public Monkey build(){
            return new Monkey(this);
        }
    }

    private Monkey(Builder builder){
        category = builder.categotry;
        age = builder.age;
        name = builder.name;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "category='" + category + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
