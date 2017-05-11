package cn.six.hard.singleton;

import java.util.ArrayList;
import java.util.List;

public final class SomeDataList {
    private static SomeDataList instance = new SomeDataList();
    private List list;

    private SomeDataList() {
    }

    public static SomeDataList getInstance() {
        return instance;
    }

    public List getList() {
        return list;
    }

    public void setList(Object... objs) {
        if(objs == null){
            list = null;
            return;
        }

        if (list == null) {
            list = new ArrayList();
        }
        for (Object obj : objs) {
            list.add(obj); // list.add(obj.clone());
        }
    }
}
