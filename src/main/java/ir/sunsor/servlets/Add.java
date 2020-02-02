package ir.sunsor.servlets;

import ir.sunsor.entities.Ticket;
import ir.sunsor.entities.Trip;
import ir.sunsor.entities.User;
import ir.sunsor.repositories.TicketRepository;
import ir.sunsor.repositories.TripRepository;
import ir.sunsor.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Add extends HttpServlet {

    static TripRepository tripRepository = TripRepository.getInstance();
    static UserRepository userRepository = UserRepository.getInstance();
    static TicketRepository ticketRepository = TicketRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tripId = req.getParameter("tripId");
        String username = (String) req.getSession().getAttribute("username");

        User user = userRepository.findByUsername(username);

        Trip trip = tripRepository.findById(Long.parseLong(tripId));

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setTrip(trip);

        ticketRepository.save(ticket);
    }
}
