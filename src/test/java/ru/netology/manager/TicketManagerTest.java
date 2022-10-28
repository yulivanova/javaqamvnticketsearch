package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;
import ru.netology.comparator.TicketTravelTimeComparator;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    TicketTravelTimeComparator comparator = new TicketTravelTimeComparator();

    Ticket ticket1 = new Ticket(1, 4_000, "LED", "GOJ", 120);
    Ticket ticket2 = new Ticket(2, 1_000, "MOW", "LED", 60);
    Ticket ticket3 = new Ticket(3, 2_000, "KZN", "MOW", 110);
    Ticket ticket4 = new Ticket(4, 5_000, "KUF", "OGZ", 480);
    Ticket ticket5 = new Ticket(5, 6_000, "KZN", "MOW", 140);

    @BeforeEach
    public void setUp() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldFindAllSort() {

        Ticket[] actual = manager.findAll("KZN", "MOW", comparator);
        Ticket[] expected = {ticket3, ticket5};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldNotFind() {

        Ticket[] actual = manager.findAll("VOL", "MOW", comparator);
        Ticket[] expected = {};
        Arrays.sort(actual);

        Assertions.assertArrayEquals(actual, expected);
    }
}































