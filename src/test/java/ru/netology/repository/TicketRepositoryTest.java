package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import java.util.Arrays;

public class TicketRepositoryTest {

    private TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 4_000, "LED", "GOJ", 120);
    Ticket ticket2 = new Ticket(2, 1_000, "MOW", "LED", 60);
    Ticket ticket3 = new Ticket(3, 2_000, "KZN", "MOW", 110);
    Ticket ticket4 = new Ticket(4, 5_000, "KUF", "OGZ", 480);
    Ticket ticket5 = new Ticket(5, 6_000, "KZN", "MOW", 140);

    @BeforeEach
    public void setUp() {

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
    }

    @Test
    public void shouldAllSort() {

        Ticket[] actual = repo.getAll();
        Ticket[] expected = {ticket2, ticket3, ticket1, ticket4};
        Arrays.sort(actual);
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAllOne() {

        repo.add(ticket5);

        Ticket[] actual = repo.getAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveById() {

        repo.add(ticket5);
        repo.removeById(1);

        Ticket[] actual = repo.getAll();
        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveByIdAll() {

        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(3);
        repo.removeById(4);

        Ticket[] actual = repo.getAll();
        Ticket[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }
}
