package ca.six.jtest.mock.mock2;

import org.junit.Test;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;

public class Account2Test {

    @Test
    public void testDefaultMock(){
        Account2 account = mock(Account2.class);
        System.out.println("ticket = "+account.getTicket());
        System.out.println("id = "+account.getId());
        System.out.println("name = "+account.getName());
        System.out.println("addr = "+account.getAddress());
    }

    @Test
    public void testSmartNulls(){
        Account2 account = mock(Account2.class, RETURNS_SMART_NULLS);
        System.out.println("ticket = "+account.getTicket());
        System.out.println("id = "+account.getId());
        System.out.println("name = "+account.getName());
        System.out.println("addr = "+account.getAddress());
    }

    @Test
    public void testDeepStubs(){
        Account2 account = mock(Account2.class, RETURNS_DEEP_STUBS);
        System.out.println("ticket = "+account.getTicket());
        System.out.println("id = "+account.getId());
        System.out.println("name = "+account.getName());
        System.out.println("addr = "+account.getAddress());
    }

}