package com.company.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

class Person{
    private String name;
    private Integer age;
    public Person(Integer age, String name) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public Person setName(String name) {
        this.name = name;
        return new Person(age,name);
    }
    public Integer getAge() {
        return age;
    }
    public Person setAge(Integer age) {
        this.age = age;
        return new Person(age,name);
    }
}
public class ConsumerTest {
    List<Person> list = new ArrayList<>();
    Consumer<Person> consumer  = x -> {
        if (x.getName().equals("lisi")){
            list.add(x);
        }
    };
    /*Stream<Person> stream = Stream.of(
            new Person(21,"zhangsan"),
            new Person(22,"lisi"),
            new Person(23,"wangwu"),
            new Person(24,"wangwu"),
            new Person(23,"lisi"),
            new Person(26,"lisi"),
            new Person(26,"zhangsan")
    ).forEach(consumer);*/
}
