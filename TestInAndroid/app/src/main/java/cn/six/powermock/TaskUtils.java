package cn.six.powermock;

public class TaskUtils {
    public static void sendTask(int id, ITaskCallback callback){
        if(id % 2 == 0){
            callback.onSucc("succ "+id);
        } else {
            callback.onFail(id);
        }
    }
}