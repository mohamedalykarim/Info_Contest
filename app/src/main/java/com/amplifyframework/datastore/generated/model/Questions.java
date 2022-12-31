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

/** This is an auto generated class representing the Questions type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Questions", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Questions implements Model {
  public static final QueryField ID = field("Questions", "id");
  public static final QueryField TYPE = field("Questions", "type");
  public static final QueryField QUESTION_TEXT = field("Questions", "questionText");
  public static final QueryField ANSWER1 = field("Questions", "answer1");
  public static final QueryField ANSWER2 = field("Questions", "answer2");
  public static final QueryField ANSWER3 = field("Questions", "answer3");
  public static final QueryField ANSWER4 = field("Questions", "answer4");
  public static final QueryField CORRECT_ANSWER = field("Questions", "correctAnswer");
  public static final QueryField COMMENT = field("Questions", "comment");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Int") Integer type;
  private final @ModelField(targetType="String") String questionText;
  private final @ModelField(targetType="String") String answer1;
  private final @ModelField(targetType="String") String answer2;
  private final @ModelField(targetType="String") String answer3;
  private final @ModelField(targetType="String") String answer4;
  private final @ModelField(targetType="String") String correctAnswer;
  private final @ModelField(targetType="String") String comment;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public Integer getType() {
      return type;
  }
  
  public String getQuestionText() {
      return questionText;
  }
  
  public String getAnswer1() {
      return answer1;
  }
  
  public String getAnswer2() {
      return answer2;
  }
  
  public String getAnswer3() {
      return answer3;
  }
  
  public String getAnswer4() {
      return answer4;
  }
  
  public String getCorrectAnswer() {
      return correctAnswer;
  }
  
  public String getComment() {
      return comment;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Questions(String id, Integer type, String questionText, String answer1, String answer2, String answer3, String answer4, String correctAnswer, String comment) {
    this.id = id;
    this.type = type;
    this.questionText = questionText;
    this.answer1 = answer1;
    this.answer2 = answer2;
    this.answer3 = answer3;
    this.answer4 = answer4;
    this.correctAnswer = correctAnswer;
    this.comment = comment;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Questions questions = (Questions) obj;
      return ObjectsCompat.equals(getId(), questions.getId()) &&
              ObjectsCompat.equals(getType(), questions.getType()) &&
              ObjectsCompat.equals(getQuestionText(), questions.getQuestionText()) &&
              ObjectsCompat.equals(getAnswer1(), questions.getAnswer1()) &&
              ObjectsCompat.equals(getAnswer2(), questions.getAnswer2()) &&
              ObjectsCompat.equals(getAnswer3(), questions.getAnswer3()) &&
              ObjectsCompat.equals(getAnswer4(), questions.getAnswer4()) &&
              ObjectsCompat.equals(getCorrectAnswer(), questions.getCorrectAnswer()) &&
              ObjectsCompat.equals(getComment(), questions.getComment()) &&
              ObjectsCompat.equals(getCreatedAt(), questions.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), questions.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getType())
      .append(getQuestionText())
      .append(getAnswer1())
      .append(getAnswer2())
      .append(getAnswer3())
      .append(getAnswer4())
      .append(getCorrectAnswer())
      .append(getComment())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Questions {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("type=" + String.valueOf(getType()) + ", ")
      .append("questionText=" + String.valueOf(getQuestionText()) + ", ")
      .append("answer1=" + String.valueOf(getAnswer1()) + ", ")
      .append("answer2=" + String.valueOf(getAnswer2()) + ", ")
      .append("answer3=" + String.valueOf(getAnswer3()) + ", ")
      .append("answer4=" + String.valueOf(getAnswer4()) + ", ")
      .append("correctAnswer=" + String.valueOf(getCorrectAnswer()) + ", ")
      .append("comment=" + String.valueOf(getComment()) + ", ")
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
  public static Questions justId(String id) {
    return new Questions(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      type,
      questionText,
      answer1,
      answer2,
      answer3,
      answer4,
      correctAnswer,
      comment);
  }
  public interface BuildStep {
    Questions build();
    BuildStep id(String id);
    BuildStep type(Integer type);
    BuildStep questionText(String questionText);
    BuildStep answer1(String answer1);
    BuildStep answer2(String answer2);
    BuildStep answer3(String answer3);
    BuildStep answer4(String answer4);
    BuildStep correctAnswer(String correctAnswer);
    BuildStep comment(String comment);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private Integer type;
    private String questionText;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;
    private String comment;
    @Override
     public Questions build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Questions(
          id,
          type,
          questionText,
          answer1,
          answer2,
          answer3,
          answer4,
          correctAnswer,
          comment);
    }
    
    @Override
     public BuildStep type(Integer type) {
        this.type = type;
        return this;
    }
    
    @Override
     public BuildStep questionText(String questionText) {
        this.questionText = questionText;
        return this;
    }
    
    @Override
     public BuildStep answer1(String answer1) {
        this.answer1 = answer1;
        return this;
    }
    
    @Override
     public BuildStep answer2(String answer2) {
        this.answer2 = answer2;
        return this;
    }
    
    @Override
     public BuildStep answer3(String answer3) {
        this.answer3 = answer3;
        return this;
    }
    
    @Override
     public BuildStep answer4(String answer4) {
        this.answer4 = answer4;
        return this;
    }
    
    @Override
     public BuildStep correctAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }
    
    @Override
     public BuildStep comment(String comment) {
        this.comment = comment;
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
    private CopyOfBuilder(String id, Integer type, String questionText, String answer1, String answer2, String answer3, String answer4, String correctAnswer, String comment) {
      super.id(id);
      super.type(type)
        .questionText(questionText)
        .answer1(answer1)
        .answer2(answer2)
        .answer3(answer3)
        .answer4(answer4)
        .correctAnswer(correctAnswer)
        .comment(comment);
    }
    
    @Override
     public CopyOfBuilder type(Integer type) {
      return (CopyOfBuilder) super.type(type);
    }
    
    @Override
     public CopyOfBuilder questionText(String questionText) {
      return (CopyOfBuilder) super.questionText(questionText);
    }
    
    @Override
     public CopyOfBuilder answer1(String answer1) {
      return (CopyOfBuilder) super.answer1(answer1);
    }
    
    @Override
     public CopyOfBuilder answer2(String answer2) {
      return (CopyOfBuilder) super.answer2(answer2);
    }
    
    @Override
     public CopyOfBuilder answer3(String answer3) {
      return (CopyOfBuilder) super.answer3(answer3);
    }
    
    @Override
     public CopyOfBuilder answer4(String answer4) {
      return (CopyOfBuilder) super.answer4(answer4);
    }
    
    @Override
     public CopyOfBuilder correctAnswer(String correctAnswer) {
      return (CopyOfBuilder) super.correctAnswer(correctAnswer);
    }
    
    @Override
     public CopyOfBuilder comment(String comment) {
      return (CopyOfBuilder) super.comment(comment);
    }
  }
  
}
