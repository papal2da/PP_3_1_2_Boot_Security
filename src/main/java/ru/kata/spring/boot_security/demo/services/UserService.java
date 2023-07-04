package ru.kata.spring.boot_security.demo.services;

import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();

    public User findOne(Long id);

    public void save(User user);

    @Transactional
    public void update(Long id, User updatedUser);
    @Transactional
    public void delete(Long id);
}
