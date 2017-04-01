package cn.six.mockito;

import android.content.Context;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import edu.emory.mathcs.backport.java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by songzhw on 2017-03-31
 */

public class MockitoTest {

    public class OnlyTwo extends ArgumentMatcher<List> {
        @Override public boolean matches(Object argument) {
            List list = (List) argument;
            return list.size() == 2;
        }
    }

    @Test
    public void testCustomMatcher(){
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
        System.out.println("(A1) = "+list.get(0)); //若上面不加第二参answer， 这里就会NPE
        System.out.println("(A2) = "+list.toArray().length);//=>0   //若上面不加第二参answer， 这里就会NPE
    }
    /*
    (1) = SmartNull returned by this unstubbed method call on a mock:
    list.get(0);
    (2) = 0
    */


    @Test
    public void returnsDeepStubs(){
        //使用RETURNS_SMART_NULLS参数创建的mock对象，不会抛出NullPointerException异常。
        List list = mock(List.class, RETURNS_DEEP_STUBS);
        System.out.println("(B1) = "+list.get(0)); //=>null  //若上面不加第二参answer， 这里就会NPE
        System.out.println("(B2) = "+list.toArray());//=>null   //若上面不加第二参answer， 这里就会NPE
//        System.out.println("(B3) = "+list.toArray().length);//=>NPE crash (加了deep_stubs这里也会NPE)
    }



}
