package cn.six.mockito;


public class InjectMockDemo {
    public User user;
    public String id;

    public InjectMockDemo(){
        id = "23";
    }

    public String modify(){
        return"[" + user.getName() + "]";
    }
}

