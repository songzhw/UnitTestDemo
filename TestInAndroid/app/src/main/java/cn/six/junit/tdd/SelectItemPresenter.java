package cn.six.junit.tdd;

public class SelectItemPresenter {
    private int[] data;

    public SelectItemPresenter() {
        data = new int[]{1, 3, 5, 7, 9, 11, 12, 13, 15, 17, 19, 20};
    }

    public int[] threeTimes() {
        int[] ret = new int[data.length];
        int index = 0;
        for (int i : data) {
            if (i % 3 == 0) {
                ret[index] = i;
                index++;
            }
        }
        return ret;
    }

    public int[] fiveTimes() {
        return new int[]{3};
    }
}
