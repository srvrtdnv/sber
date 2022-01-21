package ru.sarvartdinov.sber.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Информация о группе
 */
@ApiModel(description = "Информация о группе")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-21T12:53:25.046+05:00")

public class Group   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("isActive")
  private Boolean isActive = null;

  @JsonProperty("creationDate")
  private LocalDate creationDate = null;

  @JsonProperty("lastUpdatingDate")
  private LocalDate lastUpdatingDate = null;

  @JsonProperty("deactivatingDate")
  private LocalDate deactivatingDate = null;

  @JsonProperty("userEmails")
  @Valid
  private List<String> userEmails = null;

  public Group id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Идентификатор группы
   * @return id
  **/
  @ApiModelProperty(value = "Идентификатор группы")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Group isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  /**
   * Признак активности группы
   * @return isActive
  **/
  @ApiModelProperty(value = "Признак активности группы")


  public Boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public Group creationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Дата создания
   * @return creationDate
  **/
  @ApiModelProperty(value = "Дата создания")

  @Valid

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public Group lastUpdatingDate(LocalDate lastUpdatingDate) {
    this.lastUpdatingDate = lastUpdatingDate;
    return this;
  }

  /**
   * Дата последнего обновления
   * @return lastUpdatingDate
  **/
  @ApiModelProperty(value = "Дата последнего обновления")

  @Valid

  public LocalDate getLastUpdatingDate() {
    return lastUpdatingDate;
  }

  public void setLastUpdatingDate(LocalDate lastUpdatingDate) {
    this.lastUpdatingDate = lastUpdatingDate;
  }

  public Group deactivatingDate(LocalDate deactivatingDate) {
    this.deactivatingDate = deactivatingDate;
    return this;
  }

  /**
   * Дата отключения группы
   * @return deactivatingDate
  **/
  @ApiModelProperty(value = "Дата отключения группы")

  @Valid

  public LocalDate getDeactivatingDate() {
    return deactivatingDate;
  }

  public void setDeactivatingDate(LocalDate deactivatingDate) {
    this.deactivatingDate = deactivatingDate;
  }

  public Group userEmails(List<String> userEmails) {
    this.userEmails = userEmails;
    return this;
  }

  public Group addUserEmailsItem(String userEmailsItem) {
    if (this.userEmails == null) {
      this.userEmails = new ArrayList<>();
    }
    this.userEmails.add(userEmailsItem);
    return this;
  }

  /**
   * Почты пользователей
   * @return userEmails
  **/
  @ApiModelProperty(value = "Почты пользователей")


  public List<String> getUserEmails() {
    return userEmails;
  }

  public void setUserEmails(List<String> userEmails) {
    this.userEmails = userEmails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(this.id, group.id) &&
        Objects.equals(this.isActive, group.isActive) &&
        Objects.equals(this.creationDate, group.creationDate) &&
        Objects.equals(this.lastUpdatingDate, group.lastUpdatingDate) &&
        Objects.equals(this.deactivatingDate, group.deactivatingDate) &&
        Objects.equals(this.userEmails, group.userEmails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isActive, creationDate, lastUpdatingDate, deactivatingDate, userEmails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    lastUpdatingDate: ").append(toIndentedString(lastUpdatingDate)).append("\n");
    sb.append("    deactivatingDate: ").append(toIndentedString(deactivatingDate)).append("\n");
    sb.append("    userEmails: ").append(toIndentedString(userEmails)).append("\n");
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

