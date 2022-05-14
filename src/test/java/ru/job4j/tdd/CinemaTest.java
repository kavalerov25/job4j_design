package ru.job4j.tdd;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;


import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Ignore
    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test
    public void whenAdd() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        assertEquals(cinema.find(session -> true).get(0), new Session3D());
    }

        @Ignore
        @Test(expected = IllegalArgumentException.class)
        public void whenBuyBusyPlace() {
            Account first = new AccountCinema();
            Account sec = new AccountCinema();
            Cinema cinema = new Cinema3D();
            Calendar date = Calendar.getInstance();
            date.set(2020, 10, 10, 23, 00);
            Ticket firstTicket = cinema.buy(first, 1, 1, date);
            Ticket secondTicket = cinema.buy(first, 1, 1, date);
        }
    }
