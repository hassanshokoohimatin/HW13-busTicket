package ir.sunsor.servlets;

import ir.sunsor.entities.User;
import ir.sunsor.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class Login extends HttpServlet {

    static UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        List<User> users = userRepository.findAll().stream().filter(u->u.getUsername().equals(username))
                .filter(u->u.getPassword().equals(password)).collect(Collectors.toList());

        if (users.size()==0)
            resp.sendRedirect("wrongUserPass.jsp");
        else{
            HttpSession session = req.getSession();
            session.setAttribute("username" , username);
            resp.sendRedirect("loginSuccess.jsp");
        }
    }
}
