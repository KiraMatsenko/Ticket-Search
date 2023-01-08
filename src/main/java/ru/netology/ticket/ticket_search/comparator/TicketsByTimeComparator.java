package ru.netology.ticket.ticket_search.comparator;

import ru.netology.ticket.ticket_search.item.Ticket;
import java.util.Comparator;

public class TicketsByTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket ticket1, Ticket ticket2) {
        if (ticket1.getTime() < ticket2.getTime()) {
            return -1;
        } else if (ticket1.getTime() > ticket2.getTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}
