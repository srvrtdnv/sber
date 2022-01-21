package ru.sarvartdinov.sber.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.sarvartdinov.sber.db.entity.UserEntity;
import ru.sarvartdinov.sber.exception.UserInactiveException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Сервис по работе с пользователями
 */
public interface UsersService extends UserDetailsService {

    /**
     * Получить пользователя по логину
     * @param login логин
     * @return пользователь
     */
    UserEntity getUser(String login);

    /**
     * Получить пользователей по логинам
     *
     * @param logins список логинов
     * @return список найденных пользователей
     */
    List<UserEntity> getUsers(List<String> logins);

    /**
     * Заролнить таблицу случайно сгенерированным пользователем
     */
    void fillTableWithRandomGeneratedUser();

    /**
     * Отключить случайного пользователя
     */
    void deactivateRandomUser();

    /**
     * Получить случайного пользователя
     * @return случайный пользователь
     */
    UserEntity getRandomUser();

    /**
     * Проверить существует ли логин в системе
     * @param login логин
     * @return true - пользователь с логином существует
     */
    boolean isLoginExist(String login);


    @Override
    default UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = this.getUser(login);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Проверьте правильность введенных параметров.");
        }
        if (!user.getIsActive()) {
            throw new UserInactiveException();
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (!Objects.isNull(user.getGroups())) {
            user.getGroups().forEach(group -> authorities.add(new SimpleGrantedAuthority(group.getId())));
        }
        return new User(login, user.getPassword(), authorities);
    }

}
