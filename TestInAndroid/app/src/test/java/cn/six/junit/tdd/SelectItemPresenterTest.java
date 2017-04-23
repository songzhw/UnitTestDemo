package cn.six.junit.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelectItemPresenterTest {

    @Test
    public void testThreeTimes(){
        SelectItemPresenter p = new SelectItemPresenter();
        int[] ret = p.threeTimes();
        for(int i : ret){
            assertTrue( i % 3 == 0);
        }
    }

    @Test
    public void testThreeFiveTimes(){
        SelectItemPresenter p = new SelectItemPresenter();
        int[] tmp = p.threeTimes();
        int[] ret = p.fiveTimes();
        for(int i : ret){
            assertTrue( i % 3 == 0);
            assertTrue( i % 5 == 0);
        }
    }

}