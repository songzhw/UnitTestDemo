package cn.six.powermock.complex_parent;

public class EvilParent {
    public EvilParent() {
        System.loadLibrary("evil.dll");
    }
}