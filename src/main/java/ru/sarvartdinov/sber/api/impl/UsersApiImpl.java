package ru.sarvartdinov.sber.api.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.sarvartdinov.sber.api.UsersApiDelegate;
import ru.sarvartdinov.sber.api.model.User;
import ru.sarvartdinov.sber.db.entity.GroupEntity;
import ru.sarvartdinov.sber.db.entity.UserEntity;
import ru.sarvartdinov.sber.service.UsersService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersApiImpl implements UsersApiDelegate {

    @Autowired
    private UsersService usersService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<User>> getUsers(List<String> logins) {
        List<UserEntity> userEntities = usersService.getUsers(logins);
        if (userEntities.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getUserList(userEntities));
    }

    private List<User> getUserList(List<UserEntity> userEntities) {
        return userEntities.stream().map(this::mapToApiModel).collect(Collectors.toList());
    }

    private User mapToApiModel(UserEntity userEntity) {
        User user = modelMapper.map(userEntity, User.class);
        user.setGroupIds(userEntity.getGroups().stream().map(GroupEntity::getId).collect(Collectors.toList()));
        return user;
    }

}
