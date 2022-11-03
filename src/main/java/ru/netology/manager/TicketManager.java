package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.add(ticket);
    }

    public Ticket[] searchResult(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getAll()) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int index = tmp.length - 1;
                tmp[index] = ticket;
                result = tmp;
            }
        }

        Arrays.sort(result);
        return result;
    }
}