package cn.six.powermock._void;

import cn.six.powermock.ITaskCallback;
import cn.six.powermock.TaskUtils;

public class TaskUtilsDemo {
    public static void foo(){
        TaskUtils.sendTask(1, new ITaskCallback() {
            @Override public void onSucc(String str) { }
            @Override public void onFail(int error)  { }
        });
    }
}
