package mohalim.alarm.infocontest.ui.quiz;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\n\u00a8\u0006\'"}, d2 = {"Lmohalim/alarm/infocontest/ui/quiz/QuizViewModel;", "Landroidx/lifecycle/ViewModel;", "repositoryImp", "Lmohalim/contest/alarm/core/repository/QuestionRepositoryImp;", "(Lmohalim/contest/alarm/core/repository/QuestionRepositoryImp;)V", "correctAnswersCount", "", "getCorrectAnswersCount", "()I", "setCorrectAnswersCount", "(I)V", "currentQuestion", "Lmohalim/alarm/infocontest/core/model/question/Question;", "getCurrentQuestion", "()Lmohalim/alarm/infocontest/core/model/question/Question;", "setCurrentQuestion", "(Lmohalim/alarm/infocontest/core/model/question/Question;)V", "currentQuestionNumber", "getCurrentQuestionNumber", "setCurrentQuestionNumber", "isAudioEnabled", "", "()Z", "setAudioEnabled", "(Z)V", "questions", "", "getQuestions", "()Ljava/util/List;", "getRepositoryImp", "()Lmohalim/contest/alarm/core/repository/QuestionRepositoryImp;", "wrongAnswersCount", "getWrongAnswersCount", "setWrongAnswersCount", "retrieveQuestionForQuiz", "", "type", "binding", "Lmohalim/alarm/infocontest/databinding/ActivityQuizBinding;", "app_debug"})
public final class QuizViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final mohalim.contest.alarm.core.repository.QuestionRepositoryImp repositoryImp = null;
    @org.jetbrains.annotations.NotNull()
    private mohalim.alarm.infocontest.core.model.question.Question currentQuestion;
    private int currentQuestionNumber = 1;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<mohalim.alarm.infocontest.core.model.question.Question> questions = null;
    private int correctAnswersCount = 0;
    private int wrongAnswersCount = 0;
    private boolean isAudioEnabled = true;
    
    @javax.inject.Inject()
    public QuizViewModel(@org.jetbrains.annotations.NotNull()
    mohalim.contest.alarm.core.repository.QuestionRepositoryImp repositoryImp) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final mohalim.contest.alarm.core.repository.QuestionRepositoryImp getRepositoryImp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final mohalim.alarm.infocontest.core.model.question.Question getCurrentQuestion() {
        return null;
    }
    
    public final void setCurrentQuestion(@org.jetbrains.annotations.NotNull()
    mohalim.alarm.infocontest.core.model.question.Question p0) {
    }
    
    public final int getCurrentQuestionNumber() {
        return 0;
    }
    
    public final void setCurrentQuestionNumber(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<mohalim.alarm.infocontest.core.model.question.Question> getQuestions() {
        return null;
    }
    
    public final int getCorrectAnswersCount() {
        return 0;
    }
    
    public final void setCorrectAnswersCount(int p0) {
    }
    
    public final int getWrongAnswersCount() {
        return 0;
    }
    
    public final void setWrongAnswersCount(int p0) {
    }
    
    public final boolean isAudioEnabled() {
        return false;
    }
    
    public final void setAudioEnabled(boolean p0) {
    }
    
    public final void retrieveQuestionForQuiz(int type, @org.jetbrains.annotations.NotNull()
    mohalim.alarm.infocontest.databinding.ActivityQuizBinding binding) {
    }
}