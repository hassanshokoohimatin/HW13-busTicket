package ir.sunsor.servlets;

import ir.sunsor.entities.Trip;
import ir.sunsor.repositories.TripRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class Search extends HttpServlet {

    static TripRepository tripRepository = TripRepository.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("date");
        String origin = req.getParameter("origin");
        String destination = req.getParameter("destination");

        List<Trip> trips = tripRepository.findAll().stream().filter(t->t.getOrigin().equals(origin))
                .filter(t->t.getDestination().equals(destination))
                .filter(t->t.getTripDate().equals(date))
                .collect(Collectors.toList());

        HttpSession session =req.getSession();
        session.setAttribute("date",date);
        session.setAttribute("origin",origin);
        session.setAttribute("destination",destination);
        session.setAttribute("trips",trips);
        resp.sendRedirect("result.jsp");
    }
}
