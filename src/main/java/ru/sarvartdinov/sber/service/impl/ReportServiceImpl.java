package ru.sarvartdinov.sber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.sarvartdinov.sber.db.entity.ReportEntity;
import ru.sarvartdinov.sber.db.entity.UserEntity;
import ru.sarvartdinov.sber.db.repository.ReportCrudRepository;
import ru.sarvartdinov.sber.service.ReportService;

import java.util.List;


@Component
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportCrudRepository repository;
    @Autowired
    private Authentication authentication;

    @Override
    public void saveReport(ReportEntity report) {
        report.setOwner(new UserEntity());
        report.getOwner().setLogin(authentication.getName());
        repository.save(report);
    }

    @Override
    public List<ReportEntity> getReports(String login) {
        return repository.findReportEntityByOwner(login);
    }

}
