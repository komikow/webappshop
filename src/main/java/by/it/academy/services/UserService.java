package by.it.academy.services;

import by.it.academy.entities.User;

import java.util.List;

public interface UserService {
    User createUser(String firstName, String secondName, int age);

    List<User> readUsers();
}
