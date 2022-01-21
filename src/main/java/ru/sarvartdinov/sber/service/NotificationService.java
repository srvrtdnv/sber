package ru.sarvartdinov.sber.service;

import ru.sarvartdinov.sber.db.entity.ReportEntity;

import java.util.List;

/**
 * Сервис по работе с уведомлениями
 */
public interface NotificationService {

    /**
     * Отправить сообщение о новом отчете пользователям указанных групп
     * @param groupIds список идентификаторов групп
     * @param report отчет
     */
    void notifyGroupsWithReport(List<String> groupIds, ReportEntity report);

}
