package cn.six.robolectric.custom;

public class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public String getInfo(){
        return "name = "+name;
    }
}