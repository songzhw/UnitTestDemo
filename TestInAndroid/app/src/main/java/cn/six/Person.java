package cn.six;

/**
 * Created by songzhw on 2017-03-27
 */

public class Person {
    public int age;

    public Person(int age) {
        this.age = age;
    }

    public boolean isAdult(){
        return age >= 18;
    }
}
