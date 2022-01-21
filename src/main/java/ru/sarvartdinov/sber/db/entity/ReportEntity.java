package ru.sarvartdinov.sber.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * Сущность отчета
 */
@Entity(name = "reports")
@Data
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "some_report_data")
    private String someReportData;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner")
    private UserEntity owner;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportEntity that = (ReportEntity) o;
        return Objects.equals(someReportData, that.someReportData) && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(someReportData, owner);
    }

    @Override
    public String toString() {
        return "ReportEntity{" +
                "id=" + id +
                ", someReportData=" + someReportData +
                ", owner=" + owner.getLogin() +
                '}';
    }
}
