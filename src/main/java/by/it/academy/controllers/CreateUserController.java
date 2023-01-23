package by.it.academy.controllers;

import by.it.academy.entities.User;
import by.it.academy.repositories.UserRepositoryImpl;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/user/create"}, loadOnStartup = 0)
public class CreateUserController extends AbstractHttpServlet {

    private final static String USERS_URI = "/user/read";
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        int age = Integer.parseInt(req.getParameter("age"));
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        userService.createUser(firstName, secondName, age, login, password);
        req.getRequestDispatcher(USERS_URI).forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        List<User> users = new ArrayList<>();
        userService = new UserServiceImpl(new UserRepositoryImpl(users));
        config.getServletContext().setAttribute("userService", userService);
    }
}
