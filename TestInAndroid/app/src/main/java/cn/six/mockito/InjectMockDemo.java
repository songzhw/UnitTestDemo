package cn.six.mockito;

public class InjectMockDemo {
    public String name;

    public String modify(){
        return"[" + name.toLowerCase() + "]";
    }
}
