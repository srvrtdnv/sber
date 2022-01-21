package ru.sarvartdinov.sber.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Сущность пользователя
 */
@Entity(name = "users")
@Data
public class UserEntity {

    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "groups_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<GroupEntity> groups;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ReportEntity> reports;

    public UserEntity() {
        this.isActive = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return login.equals(that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        String groupsStr = "";
        String reportsStr = "";
        if (Objects.nonNull(groups) && !groups.isEmpty()) {
            groupsStr = "[";
            groupsStr += groups.stream().map(GroupEntity::getId).reduce((x, y) -> x + "," + y).get();
            groupsStr += "]";
        }
        if (Objects.nonNull(reports) && !reports.isEmpty()) {
            reportsStr = "[";
            reportsStr += reports.stream().map(re -> re.getId().toString()).reduce((x, y) -> x + "," + y).get();
            reportsStr += "]";
        }
        return "UserEntity{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                ", password='" + password + '\'' +
                ", groups=" + groupsStr +
                ", reports=" + reportsStr +
                '}';
    }
}
