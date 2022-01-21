package ru.sarvartdinov.sber.service.generator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.sarvartdinov.sber.db.entity.GroupEntity;
import ru.sarvartdinov.sber.service.GroupsService;

/**
 * Генератор сущности группы
 */
@Component
public class GroupGenerator {

    @Value("${group.generator.id.length}")
    private int groupIdLength;

    @Autowired
    private GroupsService groupsService;

    /**
     * Сгенерировать группу с рандомными данными
     *
     * @return сгенерированная группа
     */
    public GroupEntity generateRandomGroup() {
        GroupEntity randomGroup = new GroupEntity();
        randomGroup.setId(generateRandomId());
        return randomGroup;
    }

    private String generateRandomId() {
        String id = RandomStringUtils.randomAlphanumeric(groupIdLength);
        while (groupsService.isIdExist(id)) {
            id = RandomStringUtils.randomAlphanumeric(groupIdLength);
        }
        return id;
    }

}
