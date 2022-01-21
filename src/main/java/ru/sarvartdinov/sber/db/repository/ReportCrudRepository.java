package ru.sarvartdinov.sber.db.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.sarvartdinov.sber.db.entity.ReportEntity;

import java.util.List;

public interface ReportCrudRepository extends CrudRepository<ReportEntity, Long> {

    /**
     * Получить отчеты пользователя
     *
     * @param login логин
     * @return найденные отчеты
     */
    @Query("SELECT r FROM reports r WHERE r.owner.login = :login")
    List<ReportEntity> findReportEntityByOwner(@Param("login") String login);

}
