package ru.sarvartdinov.sber.service.generator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.sarvartdinov.sber.db.entity.GroupEntity;
import ru.sarvartdinov.sber.db.entity.UserEntity;
import ru.sarvartdinov.sber.service.GroupsService;
import ru.sarvartdinov.sber.service.UsersService;

import java.util.Collections;

/**
 * Генератор сущности пользователя
 */
@Component
public class UserGenerator {

    @Value("${user.generator.password}")
    private String password;
    @Value("${user.generator.email.suffix}")
    private String emailSuffix;
    @Value("${user.generator.email.prefix.length}")
    private int emailPrefixLength = 6;
    @Value("${user.generator.login.length}")
    private int loginLength = 6;

    @Autowired
    private GroupsService groupsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Сгенерировать пользователя с рандомными данными (в качестве группы добавляется одна рандомная из таблицы)
     *
     * @return сгенерированный пользователь
     */
    @Transactional
    public UserEntity generateRandomUser() {
        GroupEntity group = groupsService.getRandomGroup();
        UserEntity randomUser = new UserEntity();
        randomUser.setLogin(generateRandomLogin());
        randomUser.setEmail(generateRandomEmail());
        randomUser.setPassword(generateRandomPassword());
        randomUser.setGroups(Collections.singletonList(group));
        return randomUser;
    }

    private String generateRandomLogin() {
        String randomLogin = RandomStringUtils.randomAlphanumeric(loginLength);
        while (usersService.isLoginExist(randomLogin)) {
            randomLogin = RandomStringUtils.randomAlphanumeric(loginLength);
        }
        return randomLogin;
    }

    private String generateRandomEmail() {
        return RandomStringUtils.randomAlphanumeric(emailPrefixLength) + emailSuffix;
    }

    private String generateRandomPassword() {
        return passwordEncoder.encode(password);
    }

}
