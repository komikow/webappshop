package by.it.academy.repositories;

import by.it.academy.entities.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users;

    {
        users = List.of(new User("Dmitriy", "Steba", 31),
                        new User("Oleg", "Kuleshov", 38),
                        new User("Sergey", "Ovechkin", 22));
    }

    public User createUser(String firstName, String secondName, int age) {
        return null;
    }

    public List<User> readUsers() {
        return users;
    }
}
