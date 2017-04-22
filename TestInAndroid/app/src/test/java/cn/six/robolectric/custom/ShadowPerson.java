package cn.six.robolectric.custom;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;


@Implements(Person.class)
public class ShadowPerson {

    @Implementation
    public String getInfo() {
        return "mockedInfo";
    }

}