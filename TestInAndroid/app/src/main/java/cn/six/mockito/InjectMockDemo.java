package cn.six.mockito;


public class InjectMockDemo {
    public User user;

    public String modify(){
        return"[" + user.getName() + "]";
    }
}
