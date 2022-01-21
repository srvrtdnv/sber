package ru.sarvartdinov.sber.service;

import ru.sarvartdinov.sber.db.entity.ReportEntity;

import java.util.List;
/**
 * Сервис по работе с отчетами
 */
public interface ReportService {

    /**
     * Сохранить отчет
     * @param report отчет
     */
    void saveReport(ReportEntity report);

    /**
     * Получить отчеты пользователя
     * @param login логин пользователя
     * @return Список найденных отчетов
     */
    List<ReportEntity> getReports(String login);

}
