package cn.six.junit.tdd;

public class SelectItemPresenter {
    private int[] data;

    public SelectItemPresenter() {
        data = new int[]{1,3,5,7,9,11,12,13,15,17,19,20};
    }

    public int[] threeTimes() {
        return new int[]{1};
    }
}
