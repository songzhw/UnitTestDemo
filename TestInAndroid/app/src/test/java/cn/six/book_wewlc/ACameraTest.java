package cn.six.book_wewlc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ACameraTest {
    @Test
    public void testSetSnapRegion(){
        TestACamera camera = new TestACamera();
        camera.setSnapRegion(10, 10, 2, 3);
        assertEquals(12, camera.x);
    }

}

class TestACamera extends ACamera{
    // 子类中可以把权限放大。如这里从protected放大成public了
    @Override
    public void setSnapRegion(int x, int y, int dx, int dy) {
        super.setSnapRegion(x, y, dx, dy);
    }
}

