package cn.six.mockito;

public class ApplePresenter {
    public void foo(boolean is){
        if(is){
            bar();
        } else {
            System.out.println("szw !is");   
        }
    }

    public void bar() {
        System.out.println("szw bar()");
    }

}
