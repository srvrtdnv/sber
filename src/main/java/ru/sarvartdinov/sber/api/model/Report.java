package ru.sarvartdinov.sber.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Отчет
 */
@ApiModel(description = "Отчет")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-21T12:53:25.046+05:00")

public class Report   {
  @JsonProperty("someReportData")
  private String someReportData = null;

  public Report someReportData(String someReportData) {
    this.someReportData = someReportData;
    return this;
  }

  /**
   * Данные отчета
   * @return someReportData
  **/
  @ApiModelProperty(value = "Данные отчета")


  public String getSomeReportData() {
    return someReportData;
  }

  public void setSomeReportData(String someReportData) {
    this.someReportData = someReportData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Report report = (Report) o;
    return Objects.equals(this.someReportData, report.someReportData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(someReportData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Report {\n");
    
    sb.append("    someReportData: ").append(toIndentedString(someReportData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

