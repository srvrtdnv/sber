package ru.sarvartdinov.sber.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Информация о пользователе
 */
@ApiModel(description = "Информация о пользователе")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-21T12:53:25.046+05:00")

public class User   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("login")
  private String login = null;

  @JsonProperty("isActive")
  private Boolean isActive = null;

  @JsonProperty("groupIds")
  @Valid
  private List<String> groupIds = null;

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Почта
   * @return email
  **/
  @ApiModelProperty(value = "Почта")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Логин
   * @return login
  **/
  @ApiModelProperty(value = "Логин")


  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public User isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  /**
   * Признак активности
   * @return isActive
  **/
  @ApiModelProperty(value = "Признак активности")


  public Boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public User groupIds(List<String> groupIds) {
    this.groupIds = groupIds;
    return this;
  }

  public User addGroupIdsItem(String groupIdsItem) {
    if (this.groupIds == null) {
      this.groupIds = new ArrayList<>();
    }
    this.groupIds.add(groupIdsItem);
    return this;
  }

  /**
   * Идентификаторы групп
   * @return groupIds
  **/
  @ApiModelProperty(value = "Идентификаторы групп")


  public List<String> getGroupIds() {
    return groupIds;
  }

  public void setGroupIds(List<String> groupIds) {
    this.groupIds = groupIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.email, user.email) &&
        Objects.equals(this.login, user.login) &&
        Objects.equals(this.isActive, user.isActive) &&
        Objects.equals(this.groupIds, user.groupIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, login, isActive, groupIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    groupIds: ").append(toIndentedString(groupIds)).append("\n");
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

