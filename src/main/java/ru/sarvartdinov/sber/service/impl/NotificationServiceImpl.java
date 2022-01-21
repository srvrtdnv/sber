package ru.sarvartdinov.sber.service.impl;

import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sarvartdinov.sber.db.entity.GroupEntity;
import ru.sarvartdinov.sber.db.entity.MessageEntity;
import ru.sarvartdinov.sber.db.entity.ReportEntity;
import ru.sarvartdinov.sber.db.entity.UserEntity;
import ru.sarvartdinov.sber.db.repository.MessageCrudRepository;
import ru.sarvartdinov.sber.service.GroupsService;
import ru.sarvartdinov.sber.service.NotificationService;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Component
public class NotificationServiceImpl implements NotificationService {

    private static final String MESSAGE_FORMAT = "Новый отчет: %s";

    @Autowired
    private GroupsService groupsService;

    @Autowired
    private MessageCrudRepository repository;

    @Override
    public void notifyGroupsWithReport(List<String> groupIds, ReportEntity report) {
        String messageText = buildMessageText(report);
        List<GroupEntity> groups = groupsService.getGroups(groupIds);
        buildUsersSet(groups).stream().map(ue -> new MessageEntity(ue.getEmail(), messageText)).forEach(repository::save);
    }

    private Set<UserEntity> buildUsersSet(List<GroupEntity> groups) {
        Set<UserEntity> users = new HashSet<>();
        groups.stream().filter(ge -> Objects.nonNull(ge.getUsers())).forEach(ge -> users.addAll(ge.getUsers()));
        return users;
    }

    private String buildMessageText(ReportEntity report) {
        return StringFormatter.format(MESSAGE_FORMAT, report.getSomeReportData()).getValue();
    }
}
