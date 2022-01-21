package ru.sarvartdinov.sber.api.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.sarvartdinov.sber.api.GroupsApiDelegate;
import ru.sarvartdinov.sber.api.model.Group;
import ru.sarvartdinov.sber.db.entity.GroupEntity;
import ru.sarvartdinov.sber.db.entity.UserEntity;
import ru.sarvartdinov.sber.service.GroupsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupsApiImpl implements GroupsApiDelegate {

    @Autowired
    private GroupsService groupsService;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Получить информацию о группах по идентификаторам
     *
     * @param groupIds идентификаторы групп
     * @return список найденных групп
     */
    @Override
    public ResponseEntity<List<Group>> getGroups(List<String> groupIds) {
        List<GroupEntity> groupEntities = groupsService.getGroups(groupIds);
        if (groupEntities.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getGroupList(groupEntities));
    }

    private List<Group> getGroupList(List<GroupEntity> groupEntities) {
        return groupEntities.stream().map(this::mapToApiModel).collect(Collectors.toList());
    }

    private Group mapToApiModel(GroupEntity groupEntity) {
        Group gr = modelMapper.map(groupEntity, Group.class);
        gr.setUserEmails(groupEntity.getUsers().stream().map(UserEntity::getEmail).collect(Collectors.toList()));
        return gr;
    }

}
