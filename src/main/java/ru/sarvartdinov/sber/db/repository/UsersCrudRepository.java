package ru.sarvartdinov.sber.db.repository;

import org.springframework.stereotype.Repository;
import ru.sarvartdinov.sber.db.entity.UserEntity;

import java.util.List;

@Repository
public interface UsersCrudRepository extends CrudRepositoryWithRandomSearching<UserEntity, Long> {

    /**
     * Найти пользователя по логину
     * @param login логин
     * @return пользователь
     */
    UserEntity findByLogin(String login);

    /**
     * Найти пользователей по логинам
     * @param logins список логинов
     * @return список пользователей
     */
    Iterable<UserEntity> findAllByLoginIn(List<String> logins);

}
