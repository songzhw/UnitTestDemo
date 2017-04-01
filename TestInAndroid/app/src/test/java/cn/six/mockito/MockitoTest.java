package cn.six.mockito;

import org.junit.Test;
import org.mockito.ArgumentMatcher;

import java.util.List;

import edu.emory.mathcs.backport.java.util.Arrays;

import static org.mockito.Matchers.argThat;
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

}
