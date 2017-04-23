package cn.six.junit.tdd;

import java.util.Arrays;

public class SelectItemPresenter {
    private int[] data;
    private int index;

    public int[] getSelected() {
        return selected;
    }

    private int[] selected;

    public SelectItemPresenter() {
        data = new int[]{1, 3, 5, 7, 9, 11, 12, 13, 15, 17, 19, 20};
        selected = Arrays.copyOf(data, data.length);
    }

    public int[] threeTimes() {
        int[] ret = mapBase(selected, 3);
        return ret;
    }

    public int[] fiveTimes() {
        int[] ret = mapBase(selected, 5);
        return ret;
    }

    private int[] mapBase(int[] src, int base){
        int[] ret = new int[src.length];
        index = 0;
        for (int i : src) {
            if (i % base == 0) {
                ret[index] = i;
                index++;
            }
        }
        selected = Arrays.copyOf(ret, index);
        return ret;
    }
}






