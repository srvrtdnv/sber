package ru.sarvartdinov.sber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sarvartdinov.sber.db.entity.GroupEntity;
import ru.sarvartdinov.sber.db.repository.GroupsCrudRepository;
import ru.sarvartdinov.sber.exception.GroupsValidationException;
import ru.sarvartdinov.sber.service.GroupsService;
import ru.sarvartdinov.sber.service.generator.GroupGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class GroupsServiceImpl implements GroupsService {

    @Autowired
    private GroupsCrudRepository repository;
    @Autowired
    private GroupGenerator generator;

    @Override
    public List<GroupEntity> getGroups(List<String> groupIds) {
        List<GroupEntity> groups = new ArrayList<>();
        repository.findAllById(groupIds).forEach(groups::add);
        return groups;
    }

    @Override
    public GroupEntity getRandomGroup() {
        return repository.findRandom();
    }

    @Override
    public void fillTableWithRandomGeneratedGroups() {
        repository.save(generator.generateRandomGroup());
    }

    @Override
    public void deactivateRandomGroup() {
        GroupEntity group = repository.findRandom();
        if (Objects.isNull(group)) {
            return;
        }
        group.setIsActive(false);
        group.setDeactivatingDate(LocalDate.now());
        group.setLastUpdatingDate(LocalDate.now());
        repository.save(group);
    }

    @Override
    public boolean isIdExist(String id) {
        return repository.findAllById(Collections.singleton(id)).iterator().hasNext();
    }

    @Override
    public void validateGroupIds(List<String> groupIds) {
        List<GroupEntity> groups = this.getGroups(groupIds);
        long groupIdsCount = groupIds.stream().distinct().count();
        if (groups.size() < groupIdsCount) {
            throw new GroupsValidationException();
        }
    }

}
