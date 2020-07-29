package com.joke.study.designPartten.builder;

/**
 * 构建者模式
 */
public class BuilderTest {

  public static void main(String[] args) {
    Monkey monkey = new Monkey.Builder("金丝猴").age(19).name("小猴").build();
    System.out.println(monkey);

    NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();
    Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();

  }
}
