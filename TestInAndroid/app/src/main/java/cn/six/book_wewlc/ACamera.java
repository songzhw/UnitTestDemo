package cn.six.book_wewlc;

public class ACamera {
    public boolean isSnap = false;
    public int x = 0;
    private void setSnapRegion(int x, int y, int dx ,int dy){
        this.x = x + dx;
    };
    public void snap(){isSnap = true;};
}
