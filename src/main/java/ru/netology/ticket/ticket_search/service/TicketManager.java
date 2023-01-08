package ru.netology.ticket.ticket_search.service;

import ru.netology.ticket.ticket_search.item.Ticket;
import ru.netology.ticket.ticket_search.repo.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private Ticket[] tickets = new Ticket[0];
    private TicketRepository repo = new TicketRepository();

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String searchFrom, String searchTo) {
        if (ticket.getFrom().contains(searchFrom) && ticket.getTo().contains(searchTo)) {
            return true;
        } else {
            return false;
        }
    }
}
