package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenBuyNoValidDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 13, 30, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 10, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNoValidPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 12, 30, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 100, date);
    }
}
