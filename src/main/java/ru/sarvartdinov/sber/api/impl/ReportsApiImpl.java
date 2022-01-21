package ru.sarvartdinov.sber.api.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.sarvartdinov.sber.api.ReportsApiDelegate;
import ru.sarvartdinov.sber.api.model.Report;
import ru.sarvartdinov.sber.db.entity.ReportEntity;
import ru.sarvartdinov.sber.service.GroupsService;
import ru.sarvartdinov.sber.service.NotificationService;
import ru.sarvartdinov.sber.service.ReportService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportsApiImpl implements ReportsApiDelegate {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GroupsService groupsService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private NotificationService notificationService;

    @Override
    public ResponseEntity<Void> saveReport(Report body, List<String> targetGroups) {
        groupsService.validateGroupIds(targetGroups);
        reportService.saveReport(mapToEntity(body));
        notificationService.notifyGroupsWithReport(targetGroups, mapToEntity(body));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Report>> getReport(String login) {
        List<ReportEntity> reports = reportService.getReports(login);
        return ResponseEntity.ok(mapToApiModel(reports));
    }

    private ReportEntity mapToEntity(Report report) {
        return modelMapper.map(report, ReportEntity.class);
    }

    private List<Report> mapToApiModel(List<ReportEntity> reportEntities) {
        return reportEntities.stream().map(re -> modelMapper.map(re, Report.class)).collect(Collectors.toList());
    }

}
