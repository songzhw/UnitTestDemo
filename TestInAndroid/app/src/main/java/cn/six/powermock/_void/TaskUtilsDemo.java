package cn.six.powermock._void;

import cn.six.powermock.TaskUtils;

public class TaskUtilsDemo {
    public static int id = 0;

    public static void foo(){
        TaskUtils.foo();
        id = 23;
    }
}
