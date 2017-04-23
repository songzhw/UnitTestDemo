package cn.six.junit.liskov;

public class Square extends Rectangle {

    public static void main(String[] args) {
        Rectangle rect = new Square();
        rect.setWidth(3);
        rect.setHeight(4);
    }
}
