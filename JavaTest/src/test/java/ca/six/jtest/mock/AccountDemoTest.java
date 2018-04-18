package ca.six.jtest.mock;

import org.junit.Test;

import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountDemoTest {

    @Test
    public void test_smart_nulls_D1() {
        Account account = mock(Account.class, RETURNS_DEEP_STUBS);
        System.out.println("account0 = " + account);
        System.out.println("[ticket0 = " + account.getTicket() + " ]");
        System.out.println("des0 = " + account.getTicket().getDestination());
    }

    @Test
    public void test_smart_nulls_S1() {
        Account account = mock(Account.class, RETURNS_SMART_NULLS);
        System.out.println("account1 = " + account);
        System.out.println("[ticket1 = " + account.getTicket() + " ]");
        System.out.println("des1 = " + account.getTicket().getDestination());
    }

    @Test
    public void test_smart_nulls_D2() {
        Account account = mock(Account.class, RETURNS_DEEP_STUBS);
        when(account.getTicket().getDestination()).thenReturn("Hangzhou");
        System.out.println("account2 = " + account);
        System.out.println("ticket2 = " + account.getTicket());
        System.out.println("des2 = " + account.getTicket().getDestination());
    }

    @Test
    public void test_smart_nulls_S2() {
        Account account = mock(Account.class, RETURNS_SMART_NULLS);
        when(account.getTicket().getDestination()).thenReturn("China");
        System.out.println("account3 = " + account);
        System.out.println("[ticket3 = " + account.getTicket() + " ]");
        System.out.println("des3 = " + account.getTicket().getDestination());
    }

    @Test
    public void test_smart_nulls_4() {
        Account account = mock(Account.class);
        Ticket ticket = mock(Ticket.class);
        when(account.getTicket()).thenReturn(ticket);
        System.out.println("account3 = " + account);
        System.out.println("[ticket3 = " + account.getTicket() + " ]");
        System.out.println("des3 = " + account.getTicket().getDestination());
    }
}