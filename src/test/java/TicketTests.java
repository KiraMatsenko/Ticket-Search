import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ticket.ticket_search.item.Ticket;
import ru.netology.ticket.ticket_search.repo.TicketRepository;
import ru.netology.ticket.ticket_search.service.TicketManager;

public class TicketTests {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 5000, "ALA", "DYR", 120);
    Ticket ticket2 = new Ticket(2, 15000, "ESB", "KBP", 130);
    Ticket ticket3 = new Ticket(3, 20000, "ESB", "KBP", 150);
    Ticket ticket4 = new Ticket(4, 20000, "ZKP", "IWA", 300);
    Ticket ticket5 = new Ticket(5, 100000, "HEL", "NLI", 500);
    Ticket ticket6 = new Ticket(2, 10000, "ESB", "KBP", 140);

    @Test
    public void repoShouldAddTicket() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repoShouldDeleteById() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.deleteById(4);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerShouldFindTicket() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] expected = {ticket2, ticket3};
        Ticket[] actual = manager.findAll("ESB", "KBP");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerShouldNotFindTicket() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("ESB", "ESB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void itemShouldCompareCheaper() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void itemShouldCompareExpensive() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);
        ;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void itemShouldCompareEqual() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        int expected = 0;
        int actual = ticket3.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindFastest() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] expected = {ticket2, ticket6, ticket3};
        Ticket[] actual = manager.findAll("ESB", "KBP");
    }
}
