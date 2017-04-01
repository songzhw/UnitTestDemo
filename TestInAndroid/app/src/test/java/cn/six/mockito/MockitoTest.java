package cn.six.mockito;

import android.content.Context;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import edu.emory.mathcs.backport.java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by songzhw on 2017-03-31
 */

public class MockitoTest {

    public class OnlyTwo extends ArgumentMatcher<List> {
        @Override
        public boolean matches(Object argument) {
            List list = (List) argument;
            return list.size() == 2;
        }
    }

    @Test
    public void testCustomMatcher() {
        List list = mock(List.class);

        // stubb mock执行addAll方法时使用ListOfTwoElementsArgumentMatcher匹配器
        when(list.addAll(argThat(new OnlyTwo()))).thenReturn(true);

        Object o1 = "one";
        Object o2 = "two";
        Object[] ary2 = {o1, o2};
        list.addAll(Arrays.asList(ary2));

        // 验证mock是否add了两个参数
        verify(list).addAll(argThat(new OnlyTwo()));
    }

    @Test
    public void returnsSmartNullsTest() {
        //使用RETURNS_SMART_NULLS参数创建的mock对象，不会抛出NullPointerException异常。
        List list = mock(List.class, RETURNS_SMART_NULLS);
        System.out.println("(A1) = " + list.get(0)); //若上面不加第二参answer， 这里就会NPE
        System.out.println("(A2) = " + list.toArray().length);//=>0   //若上面不加第二参answer， 这里就会NPE
    }
    /*
    (1) = SmartNull returned by this unstubbed method call on a mock:
    list.get(0);
    (2) = 0
    */


    @Test
    public void returnsDeepStubs() {
        //使用RETURNS_SMART_NULLS参数创建的mock对象，不会抛出NullPointerException异常。
        List list = mock(List.class, RETURNS_DEEP_STUBS);
        System.out.println("(B1) = " + list.get(0)); //=>null  //若上面不加第二参answer， 这里就会NPE
        System.out.println("(B2) = " + list.toArray());//=>null   //若上面不加第二参answer， 这里就会NPE
//        System.out.println("(B3) = "+list.toArray().length);//=>NPE crash (加了deep_stubs这里也会NPE)
    }

    @Test
    public void customAnswer() {
        List mockList = mock(List.class);
        //使用Answer来生成我们我们期望的返回
        when(mockList.get(anyInt())).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                return "hello world:" + args[0];
            }
        });
        assertEquals("hello world:0", mockList.get(0));
        assertEquals("hello world:999", mockList.get(999));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void spy_on_real_objects(){
        List list = new LinkedList();
        List spy = Mockito.spy(list);
        //下面预设的spy.get(0)会报错，因为会调用真实对象的get(0)，所以会抛出越界异常
        when(spy.get(0)).thenReturn(3);//=> IndexOutOfBoundsException: Index: 0, Size: 0

        //使用doReturn-when可以避免when-thenReturn调用真实对象api
        doReturn(999).when(spy).get(999);
        //预设size()期望值
        when(spy.size()).thenReturn(100);
        //调用真实对象的api
        spy.add(1);
        spy.add(2);
        assertEquals(100,spy.size());
        assertEquals(1,spy.get(0));
        assertEquals(2,spy.get(1));
        verify(spy).add(1);
        verify(spy).add(2);
        assertEquals(999,spy.get(999));
        spy.get(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void spy1(){
        List list = new LinkedList();
        List spy = Mockito.spy(list);

        when(spy.get(999)).thenReturn(999);//=> IndexOutOfBoundsException: Index: 999, Size: 0

        assertEquals(999,spy.get(999));
    }

    @Test
    public void spy2(){
        List list = new LinkedList();
        List spy = Mockito.spy(list);

        doReturn(999).when(spy).get(999);//使用doReturn-when可以避免when-thenReturn调用真实对象api

        assertEquals(999,spy.get(999));
    }

    @Test
    public void spy3(){
        List list = new LinkedList();
        List spy = Mockito.spy(list);

        when(spy.size()).thenReturn(100);
        spy.add(1);// spy对象也是List类型的！
        spy.add(2);

        assertEquals(100,spy.size());
    }

}
