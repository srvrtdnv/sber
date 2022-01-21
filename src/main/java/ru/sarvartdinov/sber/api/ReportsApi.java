/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package ru.sarvartdinov.sber.api;

import ru.sarvartdinov.sber.api.model.Report;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-21T12:53:25.046+05:00")

@Api(value = "reports", description = "the reports API")
public interface ReportsApi {

    ReportsApiDelegate getDelegate();

    @ApiOperation(value = "Get report by login", nickname = "getReport", notes = "Ендпоинт для получения отчетов по указанному логину", response = Report.class, responseContainer = "List", tags={ "reportApi", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Найденные отчеты", response = Report.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Отчеты не найдены") })
    @RequestMapping(value = "/reports",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Report>> getReport(@NotNull @ApiParam(value = "Логин пользователя", required = true) @Valid @RequestParam(value = "login", required = true) String login) {
        return getDelegate().getReport(login);
    }


    @ApiOperation(value = "Finds users by ", nickname = "saveReport", notes = "Ендпоинт для отправки отчета", tags={ "reportApi", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "В случае успеха"),
        @ApiResponse(code = 400, message = "Ошибка") })
    @RequestMapping(value = "/reports",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> saveReport(@ApiParam(value = "Список пользователей, по которым необходимо отдать информацию" ,required=true )  @Valid @RequestBody Report body,@NotNull @ApiParam(value = "Идентификаторы групп для отправки отчета", required = true) @Valid @RequestParam(value = "targetGroups", required = true) List<String> targetGroups) {
        return getDelegate().saveReport(body, targetGroups);
    }

}
