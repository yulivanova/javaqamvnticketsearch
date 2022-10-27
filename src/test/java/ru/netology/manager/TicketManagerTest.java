package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 4_000, "LED", "GOJ", 120);
    Ticket ticket2 = new Ticket(2, 1_000, "MOW", "LED", 60);
    Ticket ticket3 = new Ticket(3, 2_000, "KZN", "MOW", 110);
    Ticket ticket4 = new Ticket(4, 5_000, "KUF", "OGZ", 480);
    Ticket ticket5 = new Ticket(5, 6_000, "KJA", "KZN", 240);

    @BeforeEach
    public void setUp() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldFindAll() {

        Ticket[] actual = manager.findAll("LED", "GOJ");
        Ticket[] expected = {ticket1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchResult() {

        Ticket[] actual = manager.searchResult();
        Ticket[] expected = {ticket2, ticket3, ticket1, ticket4, ticket5};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSortResult() {

        Ticket[] actual = {ticket2, ticket3, ticket1, ticket4, ticket5};
        Ticket[] expected = {ticket2, ticket3, ticket1, ticket4, ticket5};
        Arrays.sort(actual);

        Assertions.assertArrayEquals(actual, expected);
    }
}































