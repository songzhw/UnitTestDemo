package cn.six.hard.singleton;

public class SomeDataDemo {

    public int value = 0;

    public void foo(){
        if(SomeDataList.getInstance().getList() == null){
            value = 1;
        } else {
            value = 2;
        }
    }
}
