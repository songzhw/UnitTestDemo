package cn.six;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by songzhw on 2017-03-27
 */

@RunWith(JUnitParamsRunner.class)
public class PersonTest {

    @Test
    @Parameters({"17, false","22, true"})
    public void personIsAdult(int age, boolean isValid){
        assertThat(new Person(age).isAdult(), is(isValid));
    }
}
