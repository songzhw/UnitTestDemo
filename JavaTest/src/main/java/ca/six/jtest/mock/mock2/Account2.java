package ca.six.jtest.mock.mock2;

import ca.six.jtest.mock.Ticket;

import java.util.List;

public class Account2 {
    private Ticket ticket;
    private int id;
    private String name;
    private List<String> address;

    public Ticket getTicket() {
        return ticket;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getAddress() {
        return address;
    }
}
