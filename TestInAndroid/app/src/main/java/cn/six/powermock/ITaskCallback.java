package cn.six.powermock;

public interface ITaskCallback {
    void onSucc(String str);
    void onFail(int error);
}