package ru.sarvartdinov.sber.scheduler;

import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.Component;
import ru.sarvartdinov.sber.service.GroupsService;
import ru.sarvartdinov.sber.service.UsersService;

@Component
public class Scheduler {

    private GroupsService groupsService;
    private UsersService usersService;

    public Scheduler(GroupsService groupsService, UsersService usersService) {
        this.groupsService = groupsService;
        this.usersService = usersService;
    }

    @Async
    @Scheduled(fixedDelayString = "${filling.groups.delay.milliseconds}")
    public void scheduleGroupsFilling() {
        groupsService.fillTableWithRandomGeneratedGroups();
    }

    @Async
    @Scheduled(fixedDelayString = "${filling.users.delay.milliseconds}")
    public void scheduleUsersFilling() {
        usersService.fillTableWithRandomGeneratedUser();
    }

    @Async
    @Scheduled(fixedDelayString = "${deactivating.users.delay.milliseconds}")
    public void scheduleUserDeactivating() {
        usersService.deactivateRandomUser();
    }

    @Async
    @Scheduled(fixedDelayString = "${deactivating.groups.delay.milliseconds}")
    public void scheduleGroupDeactivating() {
        groupsService.deactivateRandomGroup();
    }


}
