package cn.six.mockito;

public class InjectMockDemo {
    public User user;
    public String id;

    public InjectMockDemo(String id){
        this.id = id;
    }

    public String modify(){
        return"[" + user.getName() + "]";
    }
}


