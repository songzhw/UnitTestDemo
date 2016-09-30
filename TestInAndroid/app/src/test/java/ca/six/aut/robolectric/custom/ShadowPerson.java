package ca.six.aut.robolectric.custom;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import cn.six.robolectric.custom.Person;


@Implements(Person.class)
public class ShadowPerson {

    @Implementation
    public String getInfo() {
        return "mockedInfo";
    }

}