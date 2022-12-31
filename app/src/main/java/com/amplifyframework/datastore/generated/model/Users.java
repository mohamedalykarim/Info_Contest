package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Users type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Users", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Users implements Model {
  public static final QueryField ID = field("Users", "id");
  public static final QueryField USER_NAME = field("Users", "userName");
  public static final QueryField PASSWORD = field("Users", "password");
  public static final QueryField POINTS = field("Users", "points");
  public static final QueryField USER_GROUP = field("Users", "userGroup");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String userName;
  private final @ModelField(targetType="String") String password;
  private final @ModelField(targetType="Int") Integer points;
  private final @ModelField(targetType="Int") Integer userGroup;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getUserName() {
      return userName;
  }
  
  public String getPassword() {
      return password;
  }
  
  public Integer getPoints() {
      return points;
  }
  
  public Integer getUserGroup() {
      return userGroup;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Users(String id, String userName, String password, Integer points, Integer userGroup) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.points = points;
    this.userGroup = userGroup;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Users users = (Users) obj;
      return ObjectsCompat.equals(getId(), users.getId()) &&
              ObjectsCompat.equals(getUserName(), users.getUserName()) &&
              ObjectsCompat.equals(getPassword(), users.getPassword()) &&
              ObjectsCompat.equals(getPoints(), users.getPoints()) &&
              ObjectsCompat.equals(getUserGroup(), users.getUserGroup()) &&
              ObjectsCompat.equals(getCreatedAt(), users.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), users.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserName())
      .append(getPassword())
      .append(getPoints())
      .append(getUserGroup())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Users {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("userName=" + String.valueOf(getUserName()) + ", ")
      .append("password=" + String.valueOf(getPassword()) + ", ")
      .append("points=" + String.valueOf(getPoints()) + ", ")
      .append("userGroup=" + String.valueOf(getUserGroup()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Users justId(String id) {
    return new Users(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      userName,
      password,
      points,
      userGroup);
  }
  public interface BuildStep {
    Users build();
    BuildStep id(String id);
    BuildStep userName(String userName);
    BuildStep password(String password);
    BuildStep points(Integer points);
    BuildStep userGroup(Integer userGroup);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String userName;
    private String password;
    private Integer points;
    private Integer userGroup;
    @Override
     public Users build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Users(
          id,
          userName,
          password,
          points,
          userGroup);
    }
    
    @Override
     public BuildStep userName(String userName) {
        this.userName = userName;
        return this;
    }
    
    @Override
     public BuildStep password(String password) {
        this.password = password;
        return this;
    }
    
    @Override
     public BuildStep points(Integer points) {
        this.points = points;
        return this;
    }
    
    @Override
     public BuildStep userGroup(Integer userGroup) {
        this.userGroup = userGroup;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String userName, String password, Integer points, Integer userGroup) {
      super.id(id);
      super.userName(userName)
        .password(password)
        .points(points)
        .userGroup(userGroup);
    }
    
    @Override
     public CopyOfBuilder userName(String userName) {
      return (CopyOfBuilder) super.userName(userName);
    }
    
    @Override
     public CopyOfBuilder password(String password) {
      return (CopyOfBuilder) super.password(password);
    }
    
    @Override
     public CopyOfBuilder points(Integer points) {
      return (CopyOfBuilder) super.points(points);
    }
    
    @Override
     public CopyOfBuilder userGroup(Integer userGroup) {
      return (CopyOfBuilder) super.userGroup(userGroup);
    }
  }
  
}
