package ru.sarvartdinov.sber.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Сущность группы
 */
@Entity(name = "groups_table")
@Data
public class GroupEntity {

    @Id
    @Column(length = 10, nullable = false)
    private String id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "last_updating_date")
    private LocalDate lastUpdatingDate;

    @Column(name = "deactivating_date")
    private LocalDate deactivatingDate;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private List<UserEntity> users;

    public GroupEntity() {
        this.isActive = true;
        this.creationDate = LocalDate.now();
        this.lastUpdatingDate = LocalDate.now();
    }

    public List<UserEntity> getUsers() {
        if (Objects.isNull(users)) {
            return Collections.emptyList();
        }
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupEntity that = (GroupEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String usersStr = "";
        if (Objects.nonNull(users) && !users.isEmpty()) {
            usersStr = "[";
            usersStr += users.stream().map(UserEntity::getEmail).reduce((x, y) -> x + "," + y).get();
            usersStr += "]";
        }
        return "GroupEntity{" +
                "id='" + id + '\'' +
                ", isActive=" + isActive +
                ", creationDate=" + creationDate +
                ", lastUpdatingDate=" + lastUpdatingDate +
                ", deactivatingDate=" + deactivatingDate +
                ", users=" + usersStr +
                '}';
    }

}
