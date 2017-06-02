package cn.six.powermock;

import java.io.File;
import java.io.FileInputStream;

public class TaskUtils {
    public static void foo() {
        try {
            Thread.sleep(3000);
            File file = new File("local.properties");
            FileInputStream fis = new FileInputStream(file);

        } catch (Exception e) {
        }
    }

    public static void sendTask(int id, ITaskCallback callback) {
        if (id % 2 == 0) {
            callback.onSucc("succ " + id);
        } else {
            callback.onFail(id);
        }
    }
}