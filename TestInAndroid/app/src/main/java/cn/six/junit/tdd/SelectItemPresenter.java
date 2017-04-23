package cn.six.junit.tdd;

import java.util.Arrays;

public class SelectItemPresenter {
    private int[] data;

    public int[] getSelected() {
        return selected;
    }

    private int[] selected;

    public SelectItemPresenter() {
        data = new int[]{1, 3, 5, 7, 9, 11, 12, 13, 15, 17, 19, 20};
        selected = Arrays.copyOf(data, data.length);
    }

    public int[] threeTimes() {
        int[] ret = new int[selected.length];
        int index = 0;
        for (int i : selected) {
            if (i % 3 == 0) {
                ret[index] = i;
                index++;
            }
        }
        selected = Arrays.copyOf(ret, index);
        return ret;
    }

    public int[] fiveTimes() {
        int[] ret = new int[selected.length];
        int index = 0;
        for (int i : selected) {
            if (i % 5 == 0) {
                ret[index] = i;
                index++;
            }
        }
        selected = Arrays.copyOf(ret, index);
        return ret;
    }

    private void deepCopy(){

    }
}
