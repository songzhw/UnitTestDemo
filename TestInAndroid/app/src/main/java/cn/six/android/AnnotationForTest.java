package cn.six.android;

import android.support.annotation.VisibleForTesting;

import java.util.List;

public class AnnotationForTest {
    public static List<String> ids;

    public void add(String s){
        ids.add(s);
    }

    @VisibleForTesting
    void resetForTesting(){
        ids.clear();
    }
}
