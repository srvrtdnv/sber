package ru.sarvartdinov.sber.service;

import ru.sarvartdinov.sber.db.entity.GroupEntity;

import java.util.List;

/**
 * Сервис по работе с группами
 */
public interface GroupsService {

    /**
     * Получить группы по идентификаторам
     * @param groupIds идентификаторы групп
     * @return список найденных групп
     */
    List<GroupEntity> getGroups(List<String> groupIds);

    /**
     * Получить рандомную группу
     * @return рандомная группа
     */
    GroupEntity getRandomGroup();

    /**
     * Заполнить таблицу рандомно сгенерированной группой
     */
    void fillTableWithRandomGeneratedGroups();

    /**
     * Отключить радомную группу
     */
    void deactivateRandomGroup();

    /**
     * Проверить существует ли группа с указанным идентификатором
     * @param id идентификатор группы
     * @return true - группа существует
     */
    boolean isIdExist(String id);

    /**
     * Провалидировать группы по идентификаторам
     * @param groupIds список идентификаторов
     */
    void validateGroupIds(List<String> groupIds);
}
