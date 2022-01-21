package ru.sarvartdinov.sber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sarvartdinov.sber.db.entity.UserEntity;
import ru.sarvartdinov.sber.db.repository.UsersCrudRepository;
import ru.sarvartdinov.sber.service.UsersService;
import ru.sarvartdinov.sber.service.generator.UserGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserServiceImpl implements UsersService {

    @Autowired
    private UsersCrudRepository repository;
    @Autowired
    private UserGenerator generator;

    @Override
    public UserEntity getUser(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public List<UserEntity> getUsers(List<String> logins) {
        List<UserEntity> users = new ArrayList<>();
        repository.findAllByLoginIn(logins).forEach(users::add);
        return users;
    }

    @Override
    public void fillTableWithRandomGeneratedUser() {
        repository.save(generator.generateRandomUser());
    }

    @Override
    public void deactivateRandomUser() {
        UserEntity user = repository.findRandom();
        if (Objects.isNull(user)) {
            return;
        }
        user.setIsActive(false);
        repository.save(user);
    }

    @Override
    public UserEntity getRandomUser() {
        return repository.findRandom();
    }

    @Override
    public boolean isLoginExist(String login) {
        return Objects.nonNull(repository.findByLogin(login));
    }

}
